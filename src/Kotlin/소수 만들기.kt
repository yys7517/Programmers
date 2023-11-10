package Kotlin

import kotlin.math.sqrt

/**
 * 주어진 숫자 배열 nums에서 숫자 3개를 조합하여 덧셈을 하였을때
 * 그 수가 소수가 되는 경우의 수를 리턴
 */
fun main() {
    println(
        solution(intArrayOf(1,2,3,4))
    )

    println(
        solution(intArrayOf(1,2,7,6,4))
    )
}

private fun solution(nums: IntArray): Int {
    var answer = 0

    for(i in 0 until nums.size - 2) {
        for( j in i+1 until  nums.size-1) {
            for ( k in j+1 until nums.size) {
                if( isPrime(nums[i] + nums[j] + nums[k]) ) {
                    answer++
                }
            }
        }
    }

    return answer
}

/**
 * 1과 자기 자신으로만 나누어지는 수, num이 소수인지 확인하는 함수
 */
fun isPrime(num : Int) : Boolean {
    var ret = true
    for( i in 2..sqrt(num.toDouble()).toInt() ) {
        if( num % i == 0 ) ret = false
    }

    return ret
}