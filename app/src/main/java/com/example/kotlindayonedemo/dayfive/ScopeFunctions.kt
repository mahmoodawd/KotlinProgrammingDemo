package com.example.kotlindayonedemo.dayfive


fun main() {
    var person = Person()
    person.apply {
        id = 1
        name = "Ahmed"
        gender = "male"
    }

    person.also {
        println(it)
    }

   val id =  person?.let { anyName ->
        println(anyName.name)
        anyName.id
    }
    println("id from let $id")

    val gender= person?.run {
        gender
    }
    println("Gender from run: $gender")
    with(person) {
       this.id = 2
    }

}


data class Person(var id: Int = 0, var name: String = "NoName", var gender: String = "NotSpecified")
