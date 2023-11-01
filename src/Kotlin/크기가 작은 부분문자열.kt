package Kotlin

/**
 * 숫자로 이루어진 문자열 t와 p
 * p의 길이와 같은 t의 부분 문자열 중에서
 * p보다 작거나 같은 개수를 반환
 * 1 ≤ p의 길이 ≤ 18
 * p의 길이가 18이 넘어가므로, 18자리 수가 넘으면 Long타입으로
 */
fun main() {
    println(solution("3141592","271"))
    println(solution("500220839878","7"))
    println(solution("10203","15"))
}

private fun solution(t: String, p: String): Int {
    var answer: Int = 0
    val length = p.length   // 주어진 길이

    // p의 길이와 같은 t의 부분 문자열
    for(idx in 0 .. t.length-length) {
        val part = t.substring(idx, idx+length)
//        println(part)
        if(part.toLong() <= p.toLong()) answer++
    }
    return answer
}