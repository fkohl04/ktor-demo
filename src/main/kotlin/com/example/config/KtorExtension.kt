package com.example.plugins

import com.example.Author.AuthorRepository
import com.example.Author.AuthorService
import com.example.Book.BookRepository
import com.example.Book.BookService
import io.ktor.application.Application
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun Application.getPropertyOrEmptyString(property: String): String {
    return environment.config.propertyOrNull(property)?.getString() ?: ""
}

fun initializeKodein() = Kodein.lazy {
    bind<AuthorRepository>() with singleton { AuthorRepository() }
    bind<AuthorService>() with singleton { AuthorService(kodein) }
    bind<BookRepository>() with singleton { BookRepository() }
    bind<BookService>() with singleton { BookService(kodein) }
}
