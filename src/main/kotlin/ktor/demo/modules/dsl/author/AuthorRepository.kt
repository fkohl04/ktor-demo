package ktor.demo.modules.dsl.author

import ktor.demo.modules.dsl.author.model.Author
import ktor.demo.modules.dsl.author.model.Authors
import ktor.demo.shared.extension.selectSingle
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.util.UUID

class AuthorRepository() {
    fun findAuthor(id: UUID): Author? {
        var author: Author? = null
        transaction {
            Authors.select { (Authors.id eq id) }
                .selectSingle()
                ?.let {
                    author = fromRow(it)
                }
        }
        return author
    }

    fun deleteAuthor(id: UUID) {
        transaction {
            Authors.deleteWhere { (Authors.id eq id) }
        }
    }

    fun findAllAuthors(): List<Author> {
        val AuthorList: ArrayList<Author> = arrayListOf()
        transaction {
            Authors.selectAll()
                .forEach {
                    AuthorList.add(fromRow(it))
                }
        }
        return AuthorList
    }

    fun addAuthor(author: Author): UUID? {
        if (author.id != null)
            throw IllegalArgumentException("author id is not null")

        var generatedId: UUID? = null
        transaction {
            generatedId = Authors.insertAndGetId {
                it[firstname] = author.firstname
                it[lastname] = author.lastname
            }.value
        }

        return generatedId
    }

    fun patchAuthor(author: Author): Author {
        transaction {
            Authors.update({ (Authors.id eq author.id) }) {
                it[firstname] = author.firstname
                it[lastname] = author.lastname
            }
        }
        return author
    }

    private fun fromRow(it: ResultRow) = Author(
        id = it[Authors.id].value,
        firstname = it[Authors.firstname],
        lastname = it[Authors.lastname],
    )
}
