package Kotlin

fun main() {
    println(solution(3))
    println(solution(4))
}

private fun solution(n: Int): String {
    var answer = ""
    for( count in 1..n ) {
        if( count % 2 == 0 ) {
            answer += "박"
        } else {
            answer += "수"
        }
    }
    return answer
}