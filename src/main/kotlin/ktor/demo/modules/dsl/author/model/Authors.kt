package ktor.demo.modules.dsl.author.model

import org.jetbrains.exposed.dao.UUIDTable

object Authors : UUIDTable() {
    val firstname = varchar("firstname", 42)
    val lastname = varchar("lastname", 42)
}
