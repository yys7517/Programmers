package Kotlin

fun main() {
    println(
        solution(3, intArrayOf(10, 100, 20, 150, 1, 100, 200)).contentToString()
    )

    println(
        solution(4, intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000)).contentToString()
    )
}

/**
 * k - 명예의 전당 크기
 * 상위 k번째 이내이면 명예의 전당에 점수가 실린다.
 * 첫째 날부터 마지막 날까지 명예의 전당에 실린 최하위 점수들을 리턴
 */
private fun solution(k: Int, scores: IntArray): IntArray {
    var answer: IntArray = intArrayOf()
    val answerList = mutableListOf<Int>()

    val topK = mutableListOf<Int>()

    for(score in scores) {
        if(topK.size < k)  {
            topK.add(score)
        } else if( score > topK[0] ) {
            topK[0] = score
        }

        topK.sort()
        answerList.add(topK[0])
    }

    answer = answerList.toIntArray()
    return answer
}