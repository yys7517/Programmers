package Kotlin

/*
 * 자연수 n
 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 */

fun main() {
    println(solution(12345).contentToString())
}

private fun solution(n: Long): IntArray {
    val nString = n.toString()
    val length = nString.length

    var answer = IntArray(length)
    for(i in 0 until length) {
        answer[i] = Character.getNumericValue(nString[length-1-i])
    }
    return answer
}