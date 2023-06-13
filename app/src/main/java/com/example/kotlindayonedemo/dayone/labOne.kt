package com.example.kotlindayonedemo


 fun main() {
    val name = readLine() ?: "user"
    var message = if (name.isBlank()) "Hello user" else "Hello $name"

    println(message)
}