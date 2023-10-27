package Kotlin

fun main() {
    println(solution(intArrayOf(4,7,12), booleanArrayOf(true,false,true)))     // 9
    println(solution(intArrayOf(1,2,3), booleanArrayOf(false,false,true)))      // 0
}

/**
 * absolutes - 절대값 배열
 * signs - 부호 배열
 * 부호가 true 양수
 * 부호가 false 음수
 * 실제 정수들의 합을 구하여 반환
 */
private fun solution(absolutes: IntArray, signs: BooleanArray): Int {
    var answer: Int = 0
    for( idx in signs.indices ) {
        if(signs[idx]) {
            // 양수
            answer += absolutes[idx]
        } else {
            // 음수
            answer -= absolutes[idx]
        }
    }
    return answer
}