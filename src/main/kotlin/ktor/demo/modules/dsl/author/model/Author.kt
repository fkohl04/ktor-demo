package ktor.demo.modules.dsl.author.model

import java.util.UUID

class Author(
    val id: UUID?,
    val firstname: String,
    val lastname: String
) {
    fun withId(newId: UUID): Author {
        if (id != null) throw IllegalStateException("")

        return Author(id = newId, firstname = firstname, lastname = lastname)
    }
}
