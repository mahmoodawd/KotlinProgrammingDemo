package com.example.kotlindayonedemo.dayfive

val add = fun(num1: Int, num2: Int): Int { //Anonymous
    return num1 + num2
}
val subtract = { num1: Int, num2: Int -> num1 - num2 } //Lambda
val multiply = fun(num1: Int, num2: Int): Int {
    return num1 * num2
}
val divide = { num1: Int, num2: Int -> if (num1 == 0) 0 else num1 / num2 }

fun getResult(num1: Int, num2: Int, equation: (Int, Int) -> Int): Int {
    return equation(num1, num2)
}

fun main() {

    println("addition: ${getResult(5, 6, add)}")
    println("subtraction: ${getResult(5, 6, subtract)}")
    println("multiplication: ${getResult(5, 6, multiply)}")
    println("division: ${getResult(5, 6, divide)}")
}