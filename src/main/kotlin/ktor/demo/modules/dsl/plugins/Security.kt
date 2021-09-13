package ktor.demo.modules.dsl.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import ktor.demo.modules.dsl.plugins.Security.DEMO_USER_JWT
import io.ktor.application.Application
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authentication
import io.ktor.auth.basic
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.jwt.jwt
import ktor.demo.modules.dsl.plugins.Security.CUSTOM_BASIC_AUTH

object Security {
    const val DEMO_USER_JWT = "demo-user-jwt"
    const val CUSTOM_BASIC_AUTH = "basic"
    private const val JWT_SECRET = "secret"
    val verifier: JWTVerifier = JWT.require(Algorithm.HMAC256(JWT_SECRET)).build()
}

fun Application.configureSecurity() {
    authentication {
        jwt(DEMO_USER_JWT) {
            verifier(Security.verifier)
            validate { credential ->
                if (credential.payload.getClaim("scope").asString() == "demoUser")
                    JWTPrincipal(credential.payload)
                else null
            }
        }

        basic(CUSTOM_BASIC_AUTH) {
            validate { credentials ->
                if (credentials.name == "Armstrong" && credentials.password == "Apollo") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
}
