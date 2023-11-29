package Kotlin

import kotlin.math.max

fun main() {
    println(
        solution(1,2,3,4)
            .contentToString()
    )

    println(
        solution(9,2,1,3)
            .contentToString()
    )

    println(
        solution(1,4,1,3)
            .contentToString()
    )
}

private fun solution(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
    var answer = intArrayOf()

    val resultDenom = denom1 * denom2
//    val resultNum = (resultDenom / denom1) * numer1 + (resultDenom / denom2) * numer2
    val resultNum = (denom1 * numer2) + (denom2 * numer1)

    var gcd = 1
    val max = max(resultDenom, resultNum)

    for(i in max downTo 1) {
        if( resultDenom % i == 0 && resultNum % i == 0 ) {
            gcd = i
            break
        }
    }

    answer = intArrayOf(resultNum/gcd, resultDenom/gcd)
    return answer
}
