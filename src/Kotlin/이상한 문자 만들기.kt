package Kotlin

/**
 * 각 단어의 짝수 번째 인덱스는 대문자로,
 * 홀수 번쨰 인덱스는 소문자로
 */
fun main() {
    println(solution("try hello world"))
}

private fun solution(s: String): String {
    var answer = ""

    val words = s.split(" ")
    for( idx in words.indices ) {
        for( idx1 in words[idx].indices ) {
            if( idx1 % 2 == 0 ) {
                answer += words[idx][idx1].uppercaseChar()
            } else {
                answer += words[idx][idx1].lowercaseChar()
            }
        }
        if( idx != words.size -1 ) {
            answer += " "
        }
    }
    return answer
}