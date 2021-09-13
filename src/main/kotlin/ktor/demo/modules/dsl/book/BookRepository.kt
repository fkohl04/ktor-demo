package ktor.demo.modules.dsl.book

import ktor.demo.modules.dsl.author.model.Author
import ktor.demo.modules.dsl.author.model.Authors
import ktor.demo.modules.dsl.book.model.Book
import ktor.demo.modules.dsl.book.model.Books
import ktor.demo.shared.extension.selectSingle
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.util.UUID

class BookRepository() {
    fun findBook(id: UUID): Book? {
        var book: Book? = null
        transaction {
            (Books innerJoin Authors).select { (Books.id eq id) }.selectSingle()?.let {
                book = fromRow(it)
            }
        }
        return book
    }

    fun deleteBook(id: UUID) {
        transaction {
            Books.deleteWhere { (Books.id eq id) }
        }
    }

    fun findAllBooks(): List<Book> {
        val BookList: ArrayList<Book> = arrayListOf()
        transaction {
            (Books innerJoin Authors).selectAll().forEach {
                BookList.add(fromRow(it))
            }
        }
        return BookList
    }

    fun addBook(book: Book): UUID? {
        if (book.id != null)
            throw IllegalArgumentException("book id is not null")
        if (book.author.id == null)
            throw IllegalArgumentException("author id is not null")
        var generatedId: UUID? = null
        transaction {
            generatedId = Books.insertAndGetId {
                it[title] = book.title
                it[author] = book.author.id
            }.value
        }

        return generatedId
    }

    fun patchBook(book: Book): Book {
        transaction {
            Books.update({ (Books.id eq book.id) }) {
                it[title] = book.title
                it[author] = book.author.id!!
            }
        }
        return book
    }

    private fun fromRow(it: ResultRow) = Book(
        id = it[Books.id].value, title = it[Books.title],
        author = Author(
            id = it[Books.author],
            firstname = it[Authors.firstname],
            lastname = it[Authors.lastname]
        )
    )
}
