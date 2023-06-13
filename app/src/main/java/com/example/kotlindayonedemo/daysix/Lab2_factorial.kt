package com.example.kotlindayonedemo.daysix

import kotlinx.coroutines.*


fun main() {
    runBlocking {

        val factorialValue = async {
            getFactorial(6)
        }
        println(factorialValue.await())
    }
}

suspend fun getFactorial(times: Int): Int {
    var counter = 1
    repeat(times) {
        counter *= (it + 1)
    }
    return counter
}