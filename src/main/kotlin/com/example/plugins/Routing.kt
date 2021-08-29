package com.example.plugins

import com.example.Author.installAuthorRoutes
import com.example.Book.installBookRoutes
import com.example.RouteWithAuthentication.installAuthenticatedRoute
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
