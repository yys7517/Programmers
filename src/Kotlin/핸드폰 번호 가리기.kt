package Kotlin

/**
 * 전화번호 맨 뒤 4자리를 제외한 숫자를 제외한
 * 나머지 숫자를 *로 가린 문자열을 리턴하는 함수
 */

fun main() {
    println(solution("01033334444"))
    println(solution("027778888"))
}

private fun solution(phone_number: String): String {
    var answer = ""
    for( i in 0 until phone_number.length-4) {
        answer += "*"
    }
    val lastNumbers = phone_number.substring(phone_number.length-1-3,phone_number.length)
    answer += lastNumbers
    return answer
}