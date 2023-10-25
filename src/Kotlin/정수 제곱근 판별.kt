package Kotlin

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * 임의의 양의 정수 n
 * n이 어떤 양의 정수 x의 제곱인지 아닌지 판단

 * 맞다면 x+1의 제곱을 리턴
 * 아니라면 -1을 리턴하는 함수를 작성

 * ex) n = 121 , (11+1)의 제곱인 144를 리턴
 */

fun main() {
    println(solution(121))
    println(solution(225))
}

private fun solution(n: Long): Long {
    var answer: Long = 0

    val root = sqrt(n.toDouble())
    if( root % 1.0 == 0.0 ) {
        // 제곱근이라면 ?
        answer = (root + 1.0).pow(2).toLong()
    } else {
        answer = -1
    }

    return answer
}