package Kotlin

/**
 * 각 알파벳들이 적힌 문자열 s를
 * n만큼 이동 시킨 후의 문자열로 출력해라
 * ex) a + 1 -> b
 * 아스키 코드를 이용하는 문제
 * a~z, A~Z는 각 각 26개이다.
 */

fun main() {
    println(solution("AB", 1))
    println(solution("z", 1))
    println(solution("a B z", 4))

}


private fun solution(s: String, n: Int): String {
    var answer = ""
    for(ch in s) {
        if(ch.code in 65..90) {
            // 대문자
            if(ch.code + n in 65..90) {
                answer += (ch.code + n).toChar()
            } else {
                answer += (ch.code - 26 + n).toChar()
            }
        } else if(ch.code in 97..122) {
            // 소문자
            if(ch.code + n in 97..122) {
                answer += (ch.code + n).toChar()
            } else {
                answer += (ch.code - 26 + n).toChar()
            }
        } else {
            // 공백
            answer += " "
            continue
        }
    }
    return answer
}