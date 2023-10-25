/*
정수 num이 짝수일 경우 "Even"을 반환하고
홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
 */

fun main() {
    println(solution(3))
    println(solution(4))
}

private fun solution(num: Int): String {
    var answer = "Odd"
    if( num % 2 == 0) answer = "Even"
    return answer
}