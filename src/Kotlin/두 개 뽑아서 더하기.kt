package Kotlin

fun main() {
    println(
        solution(intArrayOf(2,1,3,4,1)).contentToString()
    )

    println(
        solution(intArrayOf(5,0,2,7)).contentToString()
    )
}

/**
 * 정수 배열 numbers
 * 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
 * 오름차순으로 정렬 후 반환
 */
private fun solution(numbers: IntArray): IntArray {
    var answer: IntArray = intArrayOf()
    val answerList = mutableListOf<Int>()

    for(i in 0 until numbers.size-1) {
        for(j in i+1 until numbers.size) {
            if(!answerList.contains(numbers[i] + numbers[j])) {
                answerList.add(numbers[i]+numbers[j])
            }
        }
    }
    answer = answerList.toIntArray().sortedArray()
    return answer
}