package com.example.kotlindayonedemo.daysix

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


suspend fun main() {
    val myArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("Final Sum: ${getSumOfArray(myArray)}")

}

suspend fun getSumOfArray(myArray: Array<Int>): Int {
    var sum: Int = 0;
    runBlocking {

        val myJob = GlobalScope.launch {
            for (item in myArray) {
                sum += item
                delay(500)
                println("Current Sum : $sum")
            }

        }
        myJob.join()
    }
    return sum
}