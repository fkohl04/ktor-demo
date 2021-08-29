package com.example.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.plugins.Security.DEMO_USER_JWT
import com.example.plugins.Security.JWT_SECRET
import io.ktor.application.Application
import io.ktor.auth.authentication
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.jwt.jwt

object Security {
    const val DEMO_USER_JWT = "demo-user-jwt"
    const val JWT_SECRET = "secret"
}

fun Application.configureSecurity() {

    authentication {
        jwt(DEMO_USER_JWT) {
            verifier(
                JWT.require(Algorithm.HMAC256(JWT_SECRET)).build()
            )
            validate { credential ->
                if (credential.payload.getClaim("scope").asString() == "demoUser")
                    JWTPrincipal(credential.payload)
                else null
            }
        }
    }
}
