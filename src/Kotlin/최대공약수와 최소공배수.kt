package Kotlin

/**
 * n과 m의 최대공약수, 최소 공배수를 배열에 넣어 반환
 * 배열의 맨 앞에 최대 공약수, 그 다음 최소 공배수
 */

fun main() {
    println( solution(3,12).contentToString() )
    println( solution(2,5).contentToString() )
}

private fun solution(n: Int, m: Int): IntArray {
    var answer = IntArray(2)

    var max = if( n > m) n else m

    var gcd = 0 // 최대 공약수
    var lcm = 0 // 최소 공배수

    // 최대 공약수 구하기
    for( i in 1..max ) {
        if( n % i == 0 && m % i == 0 ) {
            gcd = i
        }
    }

    // 두 수의 곱 = (최대 공약수) x (최소 공배수)
    // 최소 공배수 = 두 수의 곱을 최대 공약수로 나누었을 때 값
    lcm = (n * m) / gcd
    answer[0] = gcd
    answer[1] = lcm

    return answer
}