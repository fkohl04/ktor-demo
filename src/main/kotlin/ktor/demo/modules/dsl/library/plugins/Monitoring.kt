package ktor.demo.modules.dsl.library.plugins

import ktor.demo.modules.dsl.library.plugins.customPlugins.CustomCallLogging
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.metrics.micrometer.MicrometerMetrics
import io.ktor.request.path
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import ktor.demo.shared.plugins.configureMicrometer
import org.slf4j.event.Level

fun Application.configureMonitoring() {
    configureCallLogging()
    configureMicrometer()

    configureCustomCallLogging()
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
