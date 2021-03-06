package ktor.demo.modules.dsl.plugins.customPlugins

import io.ktor.application.ApplicationCall
import io.ktor.application.ApplicationCallPipeline
import io.ktor.application.ApplicationCallPipeline.ApplicationPhase.Monitoring
import io.ktor.application.ApplicationFeature
import io.ktor.application.application
import io.ktor.application.log
import io.ktor.request.httpMethod
import io.ktor.request.uri
import io.ktor.util.AttributeKey
import io.ktor.util.pipeline.PipelineContext
import kotlin.system.measureTimeMillis

class CustomCallLogging(configuration: Configuration) {
    val prefix = configuration.pathPrefix

    /**
     * Class containing all plugin configurations
     */
    data class Configuration(
        var pathPrefix: String = "/"
    )

    companion object Feature : ApplicationFeature<ApplicationCallPipeline, Configuration, CustomCallLogging> {
        override val key = AttributeKey<CustomCallLogging>("CustomFeature")

        /**
         * Used to install this plugin to a call pipeline
         */
        override fun install(
            pipeline: ApplicationCallPipeline,
            configure: Configuration.() -> Unit
        ): CustomCallLogging {
            val configuration = Configuration().apply(configure)
            val feature = CustomCallLogging(configuration)

            pipeline.intercept(Monitoring) {
                logCallInfosForPathPrefix(feature.prefix)
            }
            return feature
        }

        /**
         * Measuring and logging request time
         */
        private suspend fun PipelineContext<Unit, ApplicationCall>.logCallInfosForPathPrefix(
            pathPrefix: String
        ) {
            if (!this.context.request.uri.startsWith(pathPrefix)) {
                proceed()
            } else {
                application.log.info("${this.context.request.httpMethod.value} ${this.context.request.uri}")
                val time = measureTimeMillis {
                    proceed()
                }
                application.log.info("Returning ${this.context.response.status()} for call to ${this.context.request.uri} in $time ms")
            }
        }
    }
}
