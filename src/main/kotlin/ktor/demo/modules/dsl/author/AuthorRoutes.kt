package ktor.demo.modules.dsl.author

import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.patch
import io.ktor.routing.post
import io.ktor.routing.route
import ktor.demo.modules.dsl.author.AuthorRoutes.AUTHORS
import ktor.demo.modules.dsl.author.AuthorRoutes.AUTHOR_ID
import ktor.demo.modules.dsl.author.model.Author
import ktor.demo.modules.dsl.plugins.Security
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import java.util.UUID

object AuthorRoutes {
    const val AUTHORS = "authors"
    const val AUTHOR_ID = "author-id"
}

fun Routing.installAuthorRoutes(kodein: Kodein) {
    val authorService by kodein.instance<AuthorService>()

    authenticate(Security.CUSTOM_BASIC_AUTH) {
        route("/$AUTHORS") {
            get {
                call.respond(authorService.findAllAuthors())
            }

            post {
                val author = call.receive<Author>()
                call.respond(authorService.addAuthor(author))
            }

            route("/{$AUTHOR_ID}") {

                get {
                    val id = UUID.fromString(call.parameters[AUTHOR_ID])
                    call.respond(authorService.findAuthor(id))
                }

                patch {
                    val id = UUID.fromString(call.parameters[AUTHOR_ID])
                    val author = call.receive<Author>()
                    call.respond(authorService.patchAuthor(author.withId(id)))
                }

                delete {
                    val id = UUID.fromString(call.parameters[AUTHOR_ID])
                    authorService.deleteAuthor(id)
                    call.respond(HttpStatusCode.OK)
                }
            }
        }
    }
}
