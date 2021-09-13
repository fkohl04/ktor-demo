package ktor.demo.modules.performance.client

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing
import ktor.demo.modules.dsl.config.DatabaseConfig
import ktor.demo.modules.dsl.plugins.configureMonitoring
import ktor.demo.shared.plugins.configureSerialization
import ktor.demo.shared.extension.getPropertyOrEmptyString
import ktor.demo.shared.extension.initializeDatabaseConnection
import ktor.demo.shared.extension.selectSingle
import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID

fun Application.module() {

    initializeDatabaseConnection()
    configureSerialization()
    configureMonitoring()
    val logger: Logger = LoggerFactory.getLogger(DatabaseConfig.javaClass)
    val client = HttpClient()
    val serverUrl = getPropertyOrEmptyString("server.url")
    val serverPort = getPropertyOrEmptyString("server.port")

    transaction {
        SchemaUtils.create(Randoms)
        val count = Randoms.select { Op.TRUE }.count()
        if (count == 0) {
            Randoms.batchInsert((1..1000000)) {

            }
        }
    }

    routing {
        route("/") {
            get {
                var serverResponse = client.get<HttpResponse>("$serverUrl:$serverPort")
                    .readText()
                    .toInt()

                var databaseResult: UUID? = UUID.randomUUID()

                newSuspendedTransaction {
                    databaseResult = Randoms.select {
                        (Randoms.id eq serverResponse)
                    }.selectSingle()
                        ?.let { it[Randoms.value] }
                }

                logger.info(databaseResult.toString())
                call.respond("$serverResponse:$databaseResult")
            }
        }
    }
}
