package com.example.plugins

import com.example.Author.model.Authors
import com.example.Book.model.Books
import io.ktor.application.Application
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object Database {
}

fun Application.configureDatabase() {
    Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "org.h2.Driver")
    transaction { SchemaUtils.create(Books) }
    transaction { SchemaUtils.create(Authors) }
}
