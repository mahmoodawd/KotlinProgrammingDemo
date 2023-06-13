package com.example.kotlindayonedemo.daysix

import kotlinx.coroutines.*

fun main() {
    runBlocking {

        val myJob = GlobalScope.launch {
            try {

                repeat(20) {
                    delay(500)
                    println("Repeat no: ${it + 1}")
                }
            } catch (e: CancellationException) {
                println(e.message)
            }
        }
        delay(2000)
        myJob.cancelAndJoin() //Insures that the prev job is completely cancelled
        println("Cancelled Successfully")
        delay(1000)
    }
}