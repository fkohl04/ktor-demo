package ktor.demo.shared.extension

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.Application
import ktor.demo.shared.extension.DatabaseConfig.logger
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Query
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object DatabaseConfig {
    val logger: Logger = LoggerFactory.getLogger(DatabaseConfig.javaClass)
}

fun Application.initializeDatabaseConnection() {
    logger.info("Trying to connect to database")
    Database.connect(setupConnectionPool())

    logger.info("Successfully connected to database")
}

private fun Application.setupConnectionPool(): HikariDataSource {
    val config = HikariConfig()
    config.driverClassName = getPropertyOrEmptyString("datasource.driver")
    config.jdbcUrl = getPropertyOrEmptyString("datasource.url")
    config.username = getPropertyOrEmptyString("datasource.user")
    config.password = getPropertyOrEmptyString("datasource.password")
    return HikariDataSource(config)
}

fun Query.selectSingle() = limit(1).firstOrNull()
