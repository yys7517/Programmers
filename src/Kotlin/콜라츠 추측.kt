package Kotlin

/** 콜라츠 추측
 * 주어진 수가 1이 될 때까지, 다음 작업을 반복
 * 1-1. 입력된 수가 짝수라면 2로 나눕니다.
 * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
 * 2. 결과로 나온 수에 위와 같은 작업을 1이 될 때까지 반복합니다.
 * ex) 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * 총 8번만에 1이 된다. ( 8회 )
 * 6 -> 8 return

 * 횟수를 리턴하는 함수를 작성
 *
 * 주어진 수가 1인 경우에는 0을 반환
 * 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요.
 */

fun main() {
    println(solution(1))    // 0
    println(solution(6))    // 8
    println(solution(16))    // 4
    println(solution(626331))    // -1
}

private fun solution(num: Int): Int {
    var answer = 0

    var numTemp : Long = num.toLong()
    while(numTemp != 1.toLong()) {
        answer++
        when(numTemp % 2) {
            0.toLong() -> {
                // 짝수이면
                numTemp /= 2
            }
            else -> {
                // 홀수이면
                numTemp *= 3
                numTemp += 1
            }
        }
    }
    if(answer >= 500) {
        answer = -1
    }
    return answer
}