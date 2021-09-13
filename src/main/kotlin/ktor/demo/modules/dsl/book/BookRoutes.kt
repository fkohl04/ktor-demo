package ktor.demo.modules.dsl.book

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.patch
import io.ktor.routing.post
import io.ktor.routing.route
import ktor.demo.modules.dsl.book.AuthorRoutes.BOOKS
import ktor.demo.modules.dsl.book.AuthorRoutes.BOOK_ID
import ktor.demo.modules.dsl.book.model.BookCreationDto
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import java.util.UUID

object AuthorRoutes {
    const val BOOKS = "books"
    const val BOOK_ID = "book-id"
}

fun Routing.installBookRoutes(kodein: Kodein) {
    val bookService by kodein.instance<BookService>()

    route("/$BOOKS") {

        get {
            call.respond(bookService.findAllBooks())
        }

        post {
            val book = call.receive<BookCreationDto>()
            call.respond(bookService.addBook(book))
        }

        route("/{$BOOK_ID}") {

            get {
                val id = UUID.fromString(call.parameters[BOOK_ID])
                call.respond(bookService.findBook(id))
            }

            patch {
                val id = UUID.fromString(call.parameters[BOOK_ID])
                val book = call.receive<BookCreationDto>()
                call.respond(bookService.patchBook(book.withId(id)))
            }

            delete {
                val id = UUID.fromString(call.parameters[BOOK_ID])
                bookService.deleteBook(id)
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}
