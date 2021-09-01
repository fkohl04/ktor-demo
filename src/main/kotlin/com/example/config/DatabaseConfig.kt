package com.example.config

import com.example.Author.model.Authors
import com.example.Book.model.Books
import com.example.config.DatabaseConfig.logger
import com.example.plugins.getPropertyOrEmptyString
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.Application
import io.ktor.application.log
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object DatabaseConfig {
    val logger: Logger = LoggerFactory.getLogger(DatabaseConfig.javaClass)
}

fun Application.initializeDatabaseConnection() {
    logger.info("Trying to connect to database")
    Database.connect(setupConnectionPool())

    logger.info("Trying to create tables")
    transaction { SchemaUtils.create(Books) }
    transaction { SchemaUtils.create(Authors) }

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
