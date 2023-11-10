package Kotlin

fun main() {
    println(
        solution(8,4, intArrayOf(2,3,6))
    )

    println(
        solution(5,4, intArrayOf(1,3))
    )

    println(
        solution(4, 1, intArrayOf(1,2,3,4))
    )
}

/**
 * 프로그래머스 - 덧칠하기
 */
private fun solution(n: Int, m: Int, section: IntArray): Int {
    var answer: Int = 1
    val sectionToList = section.toMutableList()

    var start = sectionToList[0]
    sectionToList.removeAt(0)

    var idx = 0
    while (idx < sectionToList.size) {
        val diff = sectionToList[idx] - start
        if( diff >= m ) {
            start = sectionToList[idx]
            answer++
        }
        idx++
    }
    return answer
}