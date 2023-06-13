package com.example.kotlindayonedemo.dayone


fun main() {
    var starsCount = 0
    var starsCount2 = 0
    var spaceCount = 0
    var lineNumber = 1
    val height = 10

    while (lineNumber <= height) {

        if (starsCount < 2 * lineNumber - 1) {
            print("*")
            starsCount++
            continue
        }


        if (spaceCount < height - lineNumber + 1) {
            print("   ")
            spaceCount++
            continue
        }
        if (starsCount2 < 2 * lineNumber - 1) {
            print("*")
            starsCount2++
            continue
        }

        if (starsCount == 2 * lineNumber - 1) {
            println()
            lineNumber++
            starsCount = 0
            starsCount2 = 0
            spaceCount = 0
        }

    }}
