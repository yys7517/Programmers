package Kotlin

/**
 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return
 * 명함의 가로 길이와 세로 길이의 정보가 담겨진 2차원 배열

 * Hint ) 사실 어떤 모서리는 가로가 될 수도 있고 세로도 될 수가 있다.
그치만 한 모서리를 가로라고 지정하면 다른 모서리는 세로가 되어야 옳다.

두 개의 모서리를 비교하여 큰 값을 전부 가로 작은 값을 전부 세로로 두면
각 모서리의 길이의 최댓값이 답이 되지않을까?

 80 60 70 60
 50 30 30 40
 */
fun main() {
    println(solution(
            arrayOf(intArrayOf(60,50), intArrayOf(30,70), intArrayOf(60, 30), intArrayOf(80, 40))
    ))

    println(solution(
        arrayOf(intArrayOf(10,7), intArrayOf(12,3), intArrayOf(8,15), intArrayOf(14,7) ,intArrayOf(5,15))
    ))

    println(solution(
        arrayOf(intArrayOf(14,4), intArrayOf(19,6), intArrayOf(6,16), intArrayOf(18,7), intArrayOf(7,11))
    ))
}

private fun solution(sizes: Array<IntArray>): Int {
    var answer: Int = 0
    val widthList = mutableListOf<Int>()
    val heightList = mutableListOf<Int>()

    for(size in sizes) {
        if(size[0] > size[1]) {
            widthList.add(size[0])
            heightList.add(size[1])
        } else {
            widthList.add(size[1])
            heightList.add(size[0])
        }
    }
    widthList.sortDescending()
    heightList.sortDescending()

    answer = widthList[0] * heightList[0]
    return answer
}