package Kotlin

/**
 * 2차원 배열의 요소들의 합을 리턴
 */
fun main() {
    val result = solution(
        arrayOf( intArrayOf(1), intArrayOf(2) ),
        arrayOf( intArrayOf(3), intArrayOf(4) )
    )

    val row = result.size
    val col = result[0].size

    for( arr in result ) {
        println( arr.contentToString() )
    }
}

private fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    var answer = arrayOf<IntArray>()
    val row = arr1.size
    val col = arr1[0].size
    answer = Array(row) { IntArray(col) }

    for( i in 0 until row) {
        for( j in 0 until col) {
            answer[i][j] = arr1[i][j] + arr2[i][j]
        }
    }
    return answer
}