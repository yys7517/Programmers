package Kotlin

fun main() {

}

/**
 * lottos : 구매한 로또의 번호
 * win_nums : 당첨 번호
 *
 * 알아보지 못하는 숫자를 lottos에서 0이라고 표기할 때,
 * 당첨될 수 있는 최고 순위와 최저 순위 순서대로 리턴

 순위 (순서 상관없이)
 * 1위 -> 6개 모두 일치
 * 2위 -> 5개
 * 3위 -> 4개
 * 4위 -> 3개
 * 5위 -> 2개
 * 6위 -> 1개 or 0개 (낙첨)
 */
private fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
    var answer: IntArray = intArrayOf()

    var count = 0       // 당첨 번호의 개수
    var zeroCount = 0   // 알아보지 못하는 수
    for( num in lottos ) {
        if( num == 0 ) zeroCount++
    }

    for( num in win_nums ) {
        if( lottos.contains(num) ) count++
    }

    val maxCount = count + zeroCount
    val minCount = count

    val answerList = mutableListOf<Int>()

    when(maxCount) {
        6 -> answerList.add(1)
        5 -> answerList.add(2)
        4 -> answerList.add(3)
        3 ->  answerList.add(4)
        2 -> answerList.add(5)
        else -> answerList.add(6)
    }

    when(minCount) {
        6 -> answerList.add(1)
        5 -> answerList.add(2)
        4 -> answerList.add(3)
        3 ->  answerList.add(4)
        2 -> answerList.add(5)
        else -> answerList.add(6)
    }

    answer = answerList.toIntArray()

    return answer
}