package Kotlin

/**
 * 자연수 n
 * 1 이상 80억 이하
 * Long 타입
 * 각 자릿수를 큰 것부터 작은 순으로 내림차순 정렬하여 리턴
 * ex) 118372 -> 873211
 */

fun main() {
    println(solution(118372))
}

private fun solution(n: Long): Long {
    val nString = n.toString()
    val list = mutableListOf<Int>()

    for( i in nString.indices ) {
        list.add(i, Character.getNumericValue(nString[i]))
    }
    list.sortDescending()

    var str = ""
    for( i in list ) {
        str += i.toString()
    }

    return str.toLong()
}