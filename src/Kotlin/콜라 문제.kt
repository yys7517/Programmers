package Kotlin

/**
 * 콜라 문제
 * 예시) 콜라 빈 병 2병을 가져가면, 새거 1병을 주는 가게가 있다.
 * 20병을 가져갔을 때, 몇 병의 새 콜라를 받을 수 있을까?
 * 20 -> (+10)
 * 10 -> (+5)
 * 4 -> (+2)
 * 1 + 1 -> (+1)
 * 총 19병의 새 콜라를 받을 수 있다.
 */
fun main() {
    println(solution(2,1,20))
    println(solution(3,1,20))
    println(solution(5,3,21))
}

/**
 * 빈 병 a개를 가져다 주면
 * b개의 새 콜라병을 준다.
 * 빈 병 n개를 가져다주면, 몇 병의 새 콜라병을 받을 수 있을까?

 * a병 미만의 콜라는 교환할 수 없다.
 */

private fun solution(a: Int, b: Int, n: Int): Int {
    var answer: Int = 0

    var temp = n

    while( temp / a > 0 ) {
        answer += (temp / a) * b    // 새로 받는 병

        temp = ((temp / a) * b) + (temp % a)    // 가게에 주고 난 나머지 + 새로 받은 병
    }

    return answer
}

