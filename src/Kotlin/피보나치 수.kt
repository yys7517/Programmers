package Kotlin

/**
 * Solution
 * @param n : n은 2..100,000
 * @return : 피보나치 수 n번째 수를 1234567로 나눈 나머지
 */
private fun solution(n: Int): Int {
    if( n < 2 ) return n
    val arr = IntArray(n + 1) { 0 }
    arr[0] = 0
    arr[1] = 1
    arr[2] = 1
    // TODO. 3 ~ n번째 피보나치 수 메모이제이션 적용하면서 구하기

    // 우리가 필요한건 n번째 피보나치 수를 1234567로 나눈 나머지 값
    /** (a + b) % n = (a % n + b % n) % n **/
    (3..n).forEach {
        arr[it] = (arr[it-1] + arr[it-2]) % 1234567
    }

    return arr[n]
}

fun main() {
    println(solution(3))
    println(solution(5))
}