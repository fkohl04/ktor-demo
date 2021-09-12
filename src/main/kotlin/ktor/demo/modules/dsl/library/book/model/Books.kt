package ktor.demo.modules.dsl.library.book.model

import ktor.demo.modules.dsl.library.author.model.Authors
import org.jetbrains.exposed.dao.UUIDTable

object Books : UUIDTable() {
    val title = varchar("title", 42)
    val author = uuid("author").references(Authors.id)
}
