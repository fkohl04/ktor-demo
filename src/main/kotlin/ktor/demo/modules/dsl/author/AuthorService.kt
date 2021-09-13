package ktor.demo.modules.dsl.author

import io.ktor.features.NotFoundException
import ktor.demo.modules.dsl.author.model.Author
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.slf4j.LoggerFactory
import java.util.UUID

class AuthorService(override val kodein: Kodein) : KodeinAware {
    private val authorRepository by kodein.instance<AuthorRepository>()
    private val logger = LoggerFactory.getLogger(AuthorService::class.java)

    fun findAuthor(id: UUID): Author {
        logger.info("Searching for author with id $id")
        return authorRepository.findAuthor(id) ?: throw NotFoundException("No Author found")
    }

    fun findAllAuthors(): List<Author> {
        logger.info("Searching all authors")
        return authorRepository.findAllAuthors()
    }

    fun addAuthor(author: Author): Author {
        logger.info("Adding author")
        val id = authorRepository.addAuthor(author) ?: throw IllegalStateException("Not able to create author")
        return author.withId(id)
    }

    fun deleteAuthor(id: UUID) {
        logger.info("Deleting author with id $id")
        authorRepository.deleteAuthor(id)
    }

    fun patchAuthor(author: Author): Author {
        logger.info("Updating author with id ${author.id}")
        return authorRepository.patchAuthor(author)
    }
}
