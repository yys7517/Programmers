package Kotlin

fun main() {
    println( solution(intArrayOf(1,2,3,4,6,7,8,0)))
    println( solution(intArrayOf(5,8,4,0,6,7,9)))
}

private fun solution(numbers: IntArray): Int {
    val list = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    for( element in numbers ) {
        list.remove(element)
    }

    var answer = list.sum()
    return answer
}