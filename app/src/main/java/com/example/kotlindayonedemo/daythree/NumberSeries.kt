package com.example.kotlindayonedemo.daythree


fun main() {
    val myNum: NumSeries
    myNum = ByThree()
    myNum.getNext()
    myNum.getNext()
    myNum.getNext()
    myNum.num = 2
    myNum.getNext()
    println(myNum.result)


}

interface NumSeries {
    var num: Int
    var result: Int
    fun getNext()
    fun reset()
}

class ByThree : NumSeries {
    override var num: Int = 0
            set(value) {
                field = value
                result = num
            }
    override var result: Int = 0


    override fun getNext() {
        result = result.plus(3)
    }

    override fun reset() {
        result = num
    }
}