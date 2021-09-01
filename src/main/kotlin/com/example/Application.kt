package com.example


import com.example.config.initializeDatabaseConnection
import com.example.plugins.configureExceptionHandling
import com.example.plugins.configureMonitoring
import com.example.plugins.configureRouting
import com.example.plugins.configureSecurity
import com.example.plugins.configureSerialization
import com.example.plugins.initializeKodein
import io.ktor.application.Application

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {

    val kodein = initializeKodein()

    initializeDatabaseConnection()

    configureSerialization()
    configureSecurity()
    configureRouting(kodein)
    configureMonitoring()
    configureExceptionHandling()
}
