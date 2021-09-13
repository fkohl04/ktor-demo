package ktor.demo.modules.dsl.plugins

import ktor.demo.modules.dsl.plugins.ExceptionHandling.logger
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.NotFoundException
import io.ktor.features.StatusPages
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.TextContent
import io.ktor.http.withCharset
import io.ktor.response.respond
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ExceptionHandling {
    val logger: Logger = LoggerFactory.getLogger(ExceptionHandling.javaClass)
}

fun Application.configureExceptionHandling() {

    install(StatusPages) {
        exception<NotFoundException> {
            logger.error("NotFound!", it)
            call.respond(HttpStatusCode.NotFound)
        }
        exception<Throwable> {
            logger.error("Unexpected behavior!", it)
            call.respond(
                HttpStatusCode.InternalServerError, "unexpected behavior"
            )
        }

        status(HttpStatusCode.Unauthorized) {
            call.respond(
                TextContent(
                    "${it.value} ${it.description}",
                    ContentType.Text.Plain.withCharset(Charsets.UTF_8),
                    it
                )
            )
        }
        status(HttpStatusCode.Forbidden) {
            call.respond(
                TextContent(
                    "${it.value} ${it.description}",
                    ContentType.Text.Plain.withCharset(Charsets.UTF_8),
                    it
                )
            )
        }
    }
}
