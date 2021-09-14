package ktor.demo.modules.dsl.config

import ktor.demo.modules.dsl.author.AuthorRepository
import ktor.demo.modules.dsl.author.AuthorService
import ktor.demo.modules.dsl.book.BookRepository
import ktor.demo.modules.dsl.book.BookService
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun initializeKodein() = Kodein.lazy {
    bind<AuthorRepository>() with singleton { AuthorRepository() }
    bind<AuthorService>() with singleton { AuthorService(kodein) }
    bind<BookRepository>() with singleton { BookRepository() }
    bind<BookService>() with singleton { BookService(kodein) }
}
