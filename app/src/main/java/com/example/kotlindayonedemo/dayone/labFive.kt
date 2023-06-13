package com.example.kotlindayonedemo


 fun main() {
     print("First Name: ")
     var firstName = readLine() ?: "No first name specified"
     print("Last Name: ")
     var lastName = readLine() ?: "No last name specified"

     if (firstName.isBlank()) firstName = "No first name specified"
     if (lastName.isBlank()) lastName = "No last name specified"
     println("$firstName $lastName")
}