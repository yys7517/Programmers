package Kotlin

/**
 * 양의 정수x가 자릿수의 합으로 x가 나누어지는 수
 * ex) 18의 자릿 수 합은 9이고, 18은 9로 나누어지므로 하샤드 수
 * 자연수 x가 하샤드 수인지 반환하는 함수를 작성하세요
 */

fun main() {
    println(solution(18))   // true
    println(solution(10))   // true
    println(solution(12))   // true
    println(solution(11))   // false
    println(solution(13))   // false

}

private fun solution(x: Int): Boolean {
    var answer = false

    // 입력 받은 수 x의 자릿 수 합
    val xString = x.toString()
    var sum = 0
    for(char in xString) {
        sum += Character.getNumericValue(char)
    }

    // x가 자릿 수 합으로 나누어지는지?
    if( x % sum == 0 ) answer = true

    return answer
}