package com.example.Book.model

import com.example.Author.model.Authors
import org.jetbrains.exposed.dao.UUIDTable

object Books : UUIDTable() {
    val title = varchar("title", 42)
    val author = uuid("author").references(Authors.id)
}
