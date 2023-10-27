package Kotlin

/**
 * String 배열 seoul의 요소 중 "Kim"의 위치 x를 찾아서
 * "김서방은 x에 있다"는 Stirng을 반환하는 함수
 *
 * "Kim"의 인덱스 값을 반환하면 될 것 같다.
 */

fun main() {
    println(solution(arrayOf("Jane", "Kim")))
}

private fun solution(seoul: Array<String>): String {
    var answer = ""

    var kimIdx = 0
    for( idx in seoul.indices ) {
        if( seoul[idx] == "Kim" ) {
            kimIdx = idx
            break
        }
    }
    answer ="김서방은 ${kimIdx}에 있다"
    return answer
}