package com.example.kotlindayonedemo

import java.util.*


fun main() {
    val random = Random()
    val myArray = IntArray(100)
    for (index in myArray.indices) {
        myArray.set(index,random.nextInt(100) )
//        myArray[index] = random.nextInt(100)
    }
    for (item in myArray) {
        when {
            item <= 10 -> println(item)
        }
    }
}