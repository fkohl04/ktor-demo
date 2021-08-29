package com.example.plugins

import com.example.plugins.customPlugins.CustomCallLogging
import io.ktor.features.*
import org.slf4j.event.*
import io.micrometer.prometheus.*
import io.ktor.metrics.micrometer.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun Application.configureMonitoring() {
    configureCallLogging()
    configureCustomCallLogging()
    configureMicrometer()
}

private fun Application.configureCallLogging() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> !call.request.path().startsWith("/authenticated-route") }
    }
}

private fun Application.configureCustomCallLogging() {
    install(CustomCallLogging) {
        pathPrefix = "/authenticated"
    }
}

private fun Application.configureMicrometer() {
    val appMicrometerRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)

    install(MicrometerMetrics) {
        registry = appMicrometerRegistry
    }

    routing {
        get("/metrics") {
            call.respond(appMicrometerRegistry.scrape())
        }
    }
}
