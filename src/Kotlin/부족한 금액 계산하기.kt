package Kotlin

/**
 * 원래 이용료는 price
 * 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다
 * 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.

 * 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return
 * 단, 금액이 부족하지 않으면 0을 return
 */
fun main() {
    println(solution(3,20,4))   // 10
}

private fun solution(price: Int, money: Int, count: Int): Long {
    var answer: Long = -1

    var cost = 0L
    for(i in 1..count) {
        cost += price * i
    }

    if( money >= cost ) answer = 0
    else answer = (cost - money).toLong()

    return answer
}