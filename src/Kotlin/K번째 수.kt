package Kotlin

import java.util.Arrays

/**
 * 배열 array에서 i부터 j번째까지 자른 후, k번째 수를 구하는 함수를 작성
 */
fun main() {
    println(
        solution(
            intArrayOf(1,5,2,6,3,7,4),
            arrayOf( intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3) )
        ).contentToString()
    )
}

/**
 * 주어진 배열 array
 * commands : [i, j, k]의 묶음
 * 주어진 배열 array를 i번째 부터 j까지 자른 후, 정렬하였을 때, K번째 수를 구하자.
 */
private fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = intArrayOf()
    val answerList = mutableListOf<Int>()

    for(command in commands) {
        val i = command[0]
        val j = command[1]
        val k = command[2]

        val partArray = array.copyOfRange(i - 1, j).sortedArray()
//        println( partArray.contentToString() )

        answerList.add(partArray[k-1])
    }

    answer = answerList.toIntArray()
    return answer
}