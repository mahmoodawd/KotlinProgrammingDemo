package com.example.kotlindayonedemo.daysix

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runInParallel()
}

fun runInParallel() {

    runBlocking {
        val job1 = launch {
            try {
                repeat(20) {
                    delay(1000)
                    println("Job 1 repeat # ${it + 1}")
                }
            } catch (e: CancellationException) {
                println(e.message)
            }
        }

        val job2 = launch {
            try {

                repeat(20) {
                    delay(1000)
                    println("Job 2 repeat # ${it + 1}")
                }
            }catch (e: CancellationException) {
                println(e.message)
            }
        }

        delay(10000)
        job1.cancel(CancellationException("Job 1 Cancellation Cause"))
        job2.cancel(CancellationException("Job 2 Cancellation Cause"))

    }
}