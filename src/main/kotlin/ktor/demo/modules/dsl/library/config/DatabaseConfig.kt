package ktor.demo.modules.dsl.library.config

import io.ktor.application.Application
import ktor.demo.modules.dsl.library.author.model.Authors
import ktor.demo.modules.dsl.library.book.model.Books
import ktor.demo.modules.dsl.library.config.DatabaseConfig.logger
import ktor.demo.shared.extension.initializeDatabaseConnection
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object DatabaseConfig {
    val logger: Logger = LoggerFactory.getLogger(DatabaseConfig.javaClass)
}

fun Application.prepareDatabase() {
    initializeDatabaseConnection()

    logger.info("Trying to create necessary tables")
    transaction { SchemaUtils.create(Books) }
    transaction { SchemaUtils.create(Authors) }
    logger.info("Created Book and Author table")
}
