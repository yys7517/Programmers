package Kotlin
/*
자연수 n
n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요.
 */
fun main() {
    println(solution(10))
    println(solution(12))
}

private fun solution(n: Int): Int {
    var answer: Int = 0
    for( i in 1..n ) {
        if( n % i == 1 ) {
            answer = i
            break
        }
    }
    return answer
}