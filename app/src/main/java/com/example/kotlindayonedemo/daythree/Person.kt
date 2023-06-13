package com.example.kotlindayonedemo.daythree

import java.util.*


fun main() {
    val person = Person(name = "Ahmed")
    val address =
        person.Address(streetName = "first st.", city = "Cairo", building = Building.APARTMENT)
    person.address = address


    val person2 = Person(name = "Mohamed")
    val address2 =
        person2.Address(streetName = "Second st.", city = "Fayoum", building = Building.VILLA)
    person2.address = address2

    println(person.toString())
    println(person2.toString())
}

data class Person(var name: String) {

    var address: Address? = null

    inner class Address(var streetName: String, var city: String, var building: Building) {
        init {
            this@Person.name = "Khaled"
        }
    }

        override fun toString(): String {
            return "$name lives in a/an ${
                address?.building.toString().lowercase(Locale.ROOT)
            } located at ${address?.streetName} ${address?.city}"
        }

}

enum class Building {
    VILLA, APARTMENT
}

/*

class Person(var name: String,  var address: Address) {


     class Address(var streetName: String, var city: String, var building: Building) {

    }

    override fun toString(): String {
        return "$name lives in a/an ${
            address?.building.toString().lowercase(Locale.ROOT)
        } located at ${address?.streetName} ${address?.city}"
    }

}

enum class Building {
    VILLA, APARTMENT
}

*/
