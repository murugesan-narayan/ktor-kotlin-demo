package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.routes.registerCustomerRoutes
import com.example.routes.registerOrderRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        registerCustomerRoutes()
        registerOrderRoutes()
        install(ContentNegotiation) {
            json()
        }
    }.start(wait = true)
}
