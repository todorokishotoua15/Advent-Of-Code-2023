package day_1

import kotlin.text.*
import java.io.File
import java.util.*

fun isInteger(str: String?) = str?.toIntOrNull()?.let { true } ?: false

fun main() {
    val filename = "input.txt"

    var file = File(filename)
    var sum = 0

    file.forEachLine {
        var first = 0
        var last = 0
        var firstind = 1000000000
        var lastind = 0
        var curr = it
        var arraylist = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var num = arrayOf("1","2","3","4","5","6","7","8","9")
        for (i in arraylist.indices) {
            if (curr.indexOf(arraylist[i]) <= firstind && curr.indexOf(arraylist[i]) != -1) {
                firstind = curr.indexOf(arraylist[i])
                first = i+1
            }
            if (curr.lastIndexOf(arraylist[i]) >= lastind && curr.lastIndexOf(arraylist[i]) != -1) {
                lastind = curr.lastIndexOf(arraylist[i])
                last = i+1
            }
        }
        for (i in num.indices) {
            if (curr.indexOf(num[i]) <= firstind && curr.indexOf(num[i]) != -1) {
                firstind = curr.indexOf(num[i])
                first = i+1
            }
            if (curr.lastIndexOf(num[i]) >= lastind &&  curr.lastIndexOf(num[i]) != -1) {
                lastind = curr.lastIndexOf(num[i])
                last = i+1
            }
        }

        // println(first*10+last)
        sum += (10*first + last)
    }

    println(sum)
}