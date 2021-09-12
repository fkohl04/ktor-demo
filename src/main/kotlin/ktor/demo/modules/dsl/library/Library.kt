package ktor.demo.modules.dsl.library

import com.example.plugins.initializeKodein
import ktor.demo.modules.dsl.library.config.prepareDatabase
import ktor.demo.modules.dsl.library.plugins.configureExceptionHandling
import ktor.demo.modules.dsl.library.plugins.configureMonitoring
import ktor.demo.modules.dsl.library.plugins.configureRouting
import ktor.demo.modules.dsl.library.plugins.configureSecurity
import ktor.demo.modules.dsl.library.plugins.configureSerialization
import io.ktor.application.Application

fun Application.module() {


    val kodein = initializeKodein()

    prepareDatabase()

    configureSerialization()
    configureSecurity()
    configureRouting(kodein)
    configureMonitoring()
    configureExceptionHandling()
}
