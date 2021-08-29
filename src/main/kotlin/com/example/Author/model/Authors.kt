package com.example.Author.model

import org.jetbrains.exposed.dao.UUIDTable

object Authors : UUIDTable() {
    val firstname = varchar("firstname", 42)
    val lastname = varchar("lastname", 42)
}
