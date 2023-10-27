package Kotlin

/**
 * 파라미터로 받는 arr에서 divisor로 나누어 떨어지는 요소만 담아 arr를 반환
 * 하나도 없다면 -1을 담아서 반환
 **/

fun main() {
    println(solution(intArrayOf(5, 9, 7, 10), 5).contentToString())
    println(solution(intArrayOf(2, 36, 1, 3), 1).contentToString())
    println(solution(intArrayOf(3, 2, 6), 10).contentToString())
}

private fun solution(arr: IntArray, divisor: Int): IntArray {
    val list = mutableListOf<Int>()
    for( element in arr ) {
        if( element % divisor == 0 ) {
            list.add(element)
        }
    }

    var answer : IntArray

    if( list.isNotEmpty() ) {
        answer = list.sorted().toIntArray()
    } else {
        answer = intArrayOf(-1)
    }
    return answer
}