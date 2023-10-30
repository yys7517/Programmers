package Kotlin

/**
 * 대문자는 소문자보다 작은 것으로 간주합니다.
 */
fun main() {
    println(solution("Zbcdefg"))
}

private fun solution(s: String): String {
    var answer = ""

    val lowerList = mutableListOf<String>()
    val upperList = mutableListOf<String>()

    for(ch in s) {
        if(ch.isLowerCase()) lowerList.add(ch.toString())
        else upperList.add(ch.toString())
    }

    lowerList.sortDescending()
    upperList.sortDescending()

    for(str in lowerList) {
        answer += str
    }

    for( str in upperList) {
        answer += str
    }

    return answer
}