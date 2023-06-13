package com.example.kotlindayonedemo.dayone


 fun main() {
     println("Enter First Number, Operator and second number separated with spaces! Ex. 5 + 6 ")
     val input = readLine()?.split(Regex("\\s+"))
     if (input?.size != 3) {
         println("Invalid input")
         println(input?.size)
         return
     }
     val firstNumber = input[0].toInt()
     val operator = input[1]
     val secondNumber = input[2].toInt()
     val result: Int = when (operator) {
         "+" -> firstNumber + secondNumber
         "-" -> firstNumber - secondNumber
         "*" -> firstNumber * secondNumber
         "/" -> if (secondNumber == 0) {
             println("Can not divide by Zero")
             return
         } else firstNumber / secondNumber
         else -> {
             println("Invalid operator")
             return
         }
     }
     println("Result: $result")
}