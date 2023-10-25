package Kotlin

import java.util.*

/*
 * 정수 x와 자연수 n
 * x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴
 */
fun main() {
    println(solution(2, 5).contentToString())
    println(solution(4, 3).contentToString())
    println(solution(-4, 2).contentToString())
}

private fun solution(x: Int, n: Int): LongArray {
    var xTemp = x.toLong()

    var answer = LongArray(n)
    for(i in 0 until n) {
        answer[i] = xTemp
        xTemp += x.toLong()
    }
    return answer
}