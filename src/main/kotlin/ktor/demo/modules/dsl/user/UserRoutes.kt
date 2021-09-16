package ktor.demo.modules.dsl.user

import ktor.demo.modules.dsl.plugins.Security.DEMO_USER_JWT
import ktor.demo.modules.dsl.user.AuthenticatedRoute.AUTHENTICATED_ROUTE
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

fun Routing.installUserRoute() {

    authenticate(DEMO_USER_JWT) {
        get("/$AUTHENTICATED_ROUTE") {
            val principal = call.principal<JWTPrincipal>()!!
            call.respondText("Hello ${principal["name"]}!")
        }
    }
}
