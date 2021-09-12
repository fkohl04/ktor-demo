package ktor.demo.modules.dsl.library.book

import ktor.demo.modules.dsl.library.author.AuthorRepository
import ktor.demo.modules.dsl.library.book.model.Book
import ktor.demo.modules.dsl.library.book.model.BookCreationDto
import io.ktor.features.NotFoundException
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.slf4j.LoggerFactory
import java.util.UUID

class BookService(override val kodein: Kodein) : KodeinAware {
    private val bookRepository by kodein.instance<BookRepository>()
    private val authorRepository by kodein.instance<AuthorRepository>()

    private val logger = LoggerFactory.getLogger(BookService::class.java)

    fun findBook(id: UUID): Book {
        logger.info("Searching for book with id $id")
        return bookRepository.findBook(id) ?: throw NotFoundException("No Author found")
    }

    fun findAllBooks(): List<Book> {
        logger.info("Searching all books")
        return bookRepository.findAllBooks()
    }

    fun addBook(bookRequest: BookCreationDto): Book {
        logger.info("Adding book")
        val author = authorRepository.findAuthor(bookRequest.author) ?: throw NotFoundException("No Author found")
        val book = Book.fromRequest(bookRequest, author)
        val id = bookRepository.addBook(book) ?: throw IllegalStateException("Not able to create book")
        return book.withId(id)
    }

    fun deleteBook(id: UUID) {
        logger.info("Deleting book with id $id")
        bookRepository.deleteBook(id)
    }

    fun patchBook(bookRequest: BookCreationDto): Book {
        logger.info("Updating book with id ${bookRequest.id}")
        val author = authorRepository.findAuthor(bookRequest.author) ?: throw NotFoundException("No Author found")
        val book = Book.fromRequest(bookRequest, author)
        return bookRepository.patchBook(book)
    }
}
