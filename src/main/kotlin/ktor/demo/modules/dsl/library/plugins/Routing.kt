package ktor.demo.modules.dsl.library.plugins

import ktor.demo.modules.dsl.library.author.installAuthorRoutes
import ktor.demo.modules.dsl.library.book.installBookRoutes
import ktor.demo.modules.dsl.library.routeWithAuthentication.installAuthenticatedRoute
import io.ktor.application.Application
import io.ktor.routing.routing
import org.kodein.di.Kodein

fun Application.configureRouting(kodein: Kodein) {
    routing {
        installAuthorRoutes(kodein)
        installBookRoutes(kodein)

        installAuthenticatedRoute()
    }
}
