package ktor.demo.modules.dsl.library.book.model

import ktor.demo.modules.dsl.library.author.model.Author
import java.util.UUID

class Book(
    val id: UUID?,
    val title: String,
    val author: Author
) {
    fun withId(newId: UUID): Book {
        if (id != null) throw IllegalStateException("")

        return Book(id = newId, title = title, author = author)
    }

    companion object {
        fun fromRequest(bookRequest: BookCreationDto, author: Author) = Book(
            id = bookRequest.id,
            title = bookRequest.title,
            author = author
        )

    }
}
