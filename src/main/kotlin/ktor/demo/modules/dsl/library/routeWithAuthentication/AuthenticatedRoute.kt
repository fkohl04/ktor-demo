package ktor.demo.modules.dsl.library.routeWithAuthentication

import ktor.demo.modules.dsl.library.plugins.Security.DEMO_USER_JWT
import ktor.demo.modules.dsl.library.routeWithAuthentication.AuthenticatedRoute.AUTHENTICATED_ROUTE
import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.principal
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get

object AuthenticatedRoute {
    const val AUTHENTICATED_ROUTE = "authenticated-route"
}

fun Routing.installAuthenticatedRoute() {

    authenticate(DEMO_USER_JWT) {
        get("/$AUTHENTICATED_ROUTE") {
            val principal = call.principal<JWTPrincipal>()!!
            call.respondText("Hello ${principal["name"]}!")
        }
    }
}
