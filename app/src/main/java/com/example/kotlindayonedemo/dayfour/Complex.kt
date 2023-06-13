package com.example.kotlindayonedemo.dayfour

import kotlin.math.absoluteValue


fun main() {
    val c1 = Complex()
    val c2 = Complex(3)
    val c3 = Complex(img = 9)
    val c4 = Complex(img = 4, real = 9)
    val c5 = Complex(5,  7)

    c1.printCmplx()
    c2.printCmplx()
    c3.printCmplx()
    c4.printCmplx()
    c5.printCmplx()

    val sum = c1 + c2
    val sub = c1 - c2

    sum.printCmplx()
    sub.printCmplx()



}

class Complex(var real: Int = 0 , var img: Int) {

    constructor(real: Int) : this(real, 0)
    constructor() : this(0)

    operator fun plus(secondOperand: Complex): Complex {
        return Complex(this.real + secondOperand.real, this.img + secondOperand.img)
    }
}

operator fun Complex.minus(secondOperand: Complex): Complex {
    return Complex(this.real - secondOperand.real, this.img - secondOperand.img)
}

fun Complex.printCmplx() = println("$real ${getSign(img)} ${img.absoluteValue} i")

fun getSign(num: Int) = if (num < 0) '-' else '+'




