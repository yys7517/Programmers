package Kotlin

fun main() {
    println(solution(intArrayOf(1,2,3,4), intArrayOf(-3,-1,0,2)))
    println(solution(intArrayOf(-1,0,1), intArrayOf(1,0,-1)))
}

private fun solution(a: IntArray, b: IntArray): Int {
    var answer: Int = 0
    for( idx in a.indices ) {
        answer += a[idx] * b[idx]
    }
    return answer
}