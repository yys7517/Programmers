package Kotlin

/**
 * 정수를 저장한 배열, arr
 * 가장 작은 수를 제거한 배열을 리턴
 * 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요
 *  예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴
 */
fun main() {
    println(solution(intArrayOf(4,3,2,1)).contentToString())
    println(solution(intArrayOf(10)).contentToString())
}

private fun solution(arr: IntArray): IntArray {
    var answer = intArrayOf()

    if(arr.size == 1) {
        answer = intArrayOf(-1)
    } else {
        // 배열에서 가장 작은 수 찾기
        var min = arr[0]
        for( element in arr ) {
            if( element < min ) {
                min = element
            }
        }

        // 가장 작은 수 제거하기
        val arrToList = arr.toMutableList()
        arrToList.remove(min)

        answer = arrToList.toIntArray()
    }

    return answer
}