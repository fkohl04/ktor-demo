package ktor.demo.modules.performance.client

import org.jetbrains.exposed.dao.IntIdTable

object Randoms : IntIdTable() {
    val value = uuid("author").autoGenerate()
}
