package Kotlin

import kotlin.math.sqrt

/**
 * 무기의 공격력은 기사 번호의 약수의 개수만큼
 * 무기를 모두 만들기 위해 필요한 철의 무게를 리턴

 * 기사단원의 수 number
 * 이웃나라 협약으로 정해진 공격력 제한수치 limit
 * 제한수치를 초과한 기사가 사용할 무기의 공격력 power
 * 공격력 1당, 철의 무게 1
 */
fun main() {
    println(
        solution(5,3,2)
    )

    println(
        solution(10,3,2)
    )
}

private fun solution(number: Int, limit: Int, power: Int): Int {
    var answer: Int = 0
    val powers = mutableListOf<Int>()
    for( i in 1..number ) {
        // powers.add(i의 약수의 개수)
        val measureCount = getMeasureCount(i)
        if( measureCount > limit ) {
            answer += power
        } else {
            answer += measureCount
        }
    }
    return answer
}

/**
 * 약수 구하기 알고리즘
 *
 * 제곱해서 number가 되는 수는 약수 중 1개를 차지한다.
 * 반면에, 나눠지는 수 i인 경우,
 * i가 약수임을 알게되면, 나머지 1개는 (number / i) 임을 당연히 알 수 있으므로, 2개를 더해준다.
 */
fun getMeasureCount(number: Int) : Int{
    var ret = 0
    for( i in 1..sqrt(number.toDouble()).toInt() ) {
        if( i * i == number ) ret++
        else if( number % i == 0 ) ret += 2
    }

    return ret
}
