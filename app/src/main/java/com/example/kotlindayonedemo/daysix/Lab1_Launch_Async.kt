package com.example.kotlindayonedemo.daysix

import kotlinx.coroutines.*


fun main() {

    printNumbersUsingAsync()

}

fun printNumbersUsingLaunch() {
    runBlocking {

        val myJob = GlobalScope.launch {
            printNumbers()
        }
        myJob.join()
    }
}

fun printNumbersUsingAsync() {
    runBlocking {

        val value = GlobalScope.async {
            printNumbers()
        }
        value.await()
    }
}

private suspend fun printNumbers() {
    repeat(10) {
        delay(1000)
        println(it + 1)
    }
}