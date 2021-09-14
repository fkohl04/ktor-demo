package ktor.demo.modules.dsl.plugins

import ktor.demo.modules.dsl.author.installAuthorRoutes
import ktor.demo.modules.dsl.book.installBookRoutes
import ktor.demo.modules.dsl.user.installUserRoute
import io.ktor.application.Application
import io.ktor.routing.routing
import org.kodein.di.Kodein

fun Application.configureRouting(kodein: Kodein) {
    routing {
        installAuthorRoutes(kodein)
        installBookRoutes(kodein)

        installUserRoute()
    }
}
