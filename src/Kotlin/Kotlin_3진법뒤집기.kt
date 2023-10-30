package Kotlin

import kotlin.math.pow

fun main() {
    println( solution(45) )
    println( solution(125) )
}

private fun solution(n: Int): Int {
    var answer: Int = 0

    val list = mutableListOf<Int>()
    var temp = n

    while( temp >= 1 ) {
        list.add(temp % 3)
        temp /= 3
    }

    println(list)

    for(idx in 0 until list.size) {
        var add = list[idx]

        if( add == 0) continue

        for(count in 1 until list.size - idx) {
            add *= 3
        }

        answer += add
    }

    return answer
}