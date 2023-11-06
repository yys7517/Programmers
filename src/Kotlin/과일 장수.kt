package Kotlin

fun main() {
    println(
        solution(3, 4, intArrayOf(1,2,3,1,2,3,1))
    )

    println(
        solution(4,3, intArrayOf(4,1,2,2,4,4,4,4,1,2,4,2))
    )
}

/**
 * k - 사과의 상태에 따른 점수 (사과 점수 : 1~k점)
 * m - 한 상자에 담는 개수
 * (최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수) =  사과 상자 가격

 * 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산
 */
private fun solution(k: Int, m: Int, scores: IntArray): Int {
    var answer: Int = 0

    val scoreList = scores.toMutableList()
    scoreList.sortDescending()      // 큰 점수가 앞으로 오게

    for (count in 0 until scoreList.size / m ) {
        // subList를 사용하여 특정 범위의 리스트 단위 추출 가능
        val box = scoreList.subList(count * m , (count+1) * m)
//        println(box)

        // 박스 가격
        box.sort()
        var min = box[0]    // 오름차순 정렬했으므로 0번째 인덱스가 최소값
        answer += min * m
    }

    return answer
}