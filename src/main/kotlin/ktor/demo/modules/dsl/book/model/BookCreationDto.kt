package ktor.demo.modules.dsl.book.model

import java.util.UUID

class BookCreationDto(
    val id: UUID?,
    val title: String,
    val author: UUID
) {
    fun withId(newId: UUID): BookCreationDto {
        if (id != null) throw IllegalStateException("")

        return BookCreationDto(id = newId, title = title, author = author)
    }
}
