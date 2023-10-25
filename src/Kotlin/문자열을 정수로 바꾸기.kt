package Kotlin

/*
 * 문자열 str를 숫자로 변환한 결과를 반환
 */

fun main() {
    println(solution("+1234"))
    println(solution("-1234"))
}

private fun solution(str: String): Int {
    var answer = 0
    var isMinus = false
    for( i in str.indices ) {
        if( str[i] == '-' ) isMinus = true
    }
    answer = str.toInt()
    return answer
}