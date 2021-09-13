package ktor.demo.modules.dsl.plugins

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.request.path
import ktor.demo.modules.dsl.plugins.customPlugins.CustomCallLogging
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
        filter { call ->
            call.request.path().let {
                !it.startsWith("/authenticated-route") && !it.startsWith("/metrics")
            }
        }
    }
}

private fun Application.configureCustomCallLogging() {
    install(CustomCallLogging) {
        pathPrefix = "/authenticated"
    }
}
