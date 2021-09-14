package ktor.demo.modules.dsl

import ktor.demo.modules.dsl.config.initializeKodein
import io.ktor.application.Application
import ktor.demo.modules.dsl.config.prepareDatabase
import ktor.demo.modules.dsl.plugins.configureExceptionHandling
import ktor.demo.modules.dsl.plugins.configureMonitoring
import ktor.demo.modules.dsl.plugins.configureRouting
import ktor.demo.modules.dsl.plugins.configureSecurity
import ktor.demo.shared.plugins.configureSerialization

fun Application.module() {
    val kodein = initializeKodein()

    prepareDatabase()

    configureSerialization()
    configureSecurity()
    configureRouting(kodein)
    configureMonitoring()
    configureExceptionHandling()
}
