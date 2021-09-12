package com.example.plugins

import ktor.demo.modules.dsl.library.author.AuthorRepository
import ktor.demo.modules.dsl.library.author.AuthorService
import ktor.demo.modules.dsl.library.book.BookRepository
import ktor.demo.modules.dsl.library.book.BookService
import io.ktor.application.Application
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun initializeKodein() = Kodein.lazy {
    bind<AuthorRepository>() with singleton { AuthorRepository() }
    bind<AuthorService>() with singleton { AuthorService(kodein) }
    bind<BookRepository>() with singleton { BookRepository() }
    bind<BookService>() with singleton { BookService(kodein) }
}
