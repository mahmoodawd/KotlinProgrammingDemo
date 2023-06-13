package com.example.kotlindayonedemo.daytwo

import kotlin.math.PI


abstract class Shape() {
    var dim: Double = 0.0
        set(value) {
            field = if (value >= 0) value else 0.0
        }

    abstract fun calcArea(): Double;
}

class Rectangle() : Shape() {
    var height: Double = 0.0
        set(value) {
            field = if (value >= 0) value else 0.0
        }

    constructor(width: Double, height: Double) : this() {
        this.height = height
    }

    override fun calcArea(): Double {
        return height * dim
    }
}

class Triangle() : Shape() {
    var base: Double = 0.0
        set(value) {
            field = if (value >= 0) value else 0.0
        }


    constructor(height: Double, base: Double) : this() {
        this.base = base
    }

    override fun calcArea(): Double {
        return 0.5 * base * dim
    }
}

class Circle() : Shape() {

    constructor(radius: Double) : this() {
        dim = radius
    }

    override fun calcArea(): Double {
        return this.dim * this.dim * PI
    }

}

class Picture() {
    fun sumAreas(sh1: Shape, sh2: Shape, sh3: Shape): Double {
        var sum = 0.0

        sum = sh1.calcArea() + sh2.calcArea() + sh3.calcArea()
        return sum
    }

    fun sumAreas(vararg shapes: Shape): Double {
        var sum = 0.0

        for (shape in shapes) {
            sum += shape.calcArea()
        }
        return sum
    }
}

fun main() {
    val rectangle = Rectangle(width = 10.0, height = 20.0)
    val rectangle2 = Rectangle()
    val rectangle3 = Rectangle(width = 10.0, height = 10.0)
    val triangle = Triangle(height = 20.0, base = 10.0)
    val triangle2 = Triangle(height = 20.0, base = 10.0)
    val circle = Circle(radius = 15.0)
    val circle2 = Circle(radius = 15.0)
    val circle3 = Circle(radius = 2.0)
    val picture = Picture()

    rectangle2.height = 10.0
    rectangle2.dim = 2.0

    println(picture.sumAreas(rectangle2, circle2, circle, rectangle))
}

