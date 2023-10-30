package Kotlin

fun main() {
    println(solution("abcde"))
    println(solution("qwer"))
}

private fun solution(s: String): String {
    var answer = ""

    val length = s.length
    answer = if( length % 2 == 0) {
        // (s.length / 2) - 1 ~ s.length / 2
        s.substring((length/2) - 1, (length/2) + 1)
    } else {
        s[length/2].toString()
    }

    return answer
}