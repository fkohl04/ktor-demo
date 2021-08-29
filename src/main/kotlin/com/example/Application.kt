package com.example


import com.example.plugins.configureMonitoring
import com.example.plugins.configureRouting
import com.example.plugins.configureSecurity
import com.example.plugins.configureSerialization
import com.example.Author.AuthorRepository
import com.example.Author.AuthorService
import com.example.Book.BookRepository
import com.example.Book.BookService
import com.example.plugins.configureDatabase
import com.example.plugins.configureExceptionHandling
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.NotFoundException
import io.ktor.features.StatusPages
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.TextContent
import io.ktor.http.withCharset
import io.ktor.response.respond
import org.jetbrains.exposed.dao.UUIDTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {

    val kodein = Kodein.lazy {
        bind<AuthorRepository>() with singleton { AuthorRepository() }
        bind<AuthorService>() with singleton { AuthorService(kodein) }
        bind<BookRepository>() with singleton { BookRepository() }
        bind<BookService>() with singleton { BookService(kodein) }
    }

    configureSerialization()
    configureSecurity()
    configureRouting(kodein)
    configureDatabase()
    configureMonitoring()
    configureExceptionHandling()
}
