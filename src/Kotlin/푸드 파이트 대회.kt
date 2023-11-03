package Kotlin

fun main() {
    println(
        solution(intArrayOf(1,3,4,6))
    )

    println(
        solution(intArrayOf(1,7,1,2))
    )
}

/**
 * food = 물과 음식 개수의 배열
 * food[0]은 물이며, 항상 1이다.
 * foor[i]는 i번 음식의 수
 * 칼로리가 적은 순서대로 담겨있다.
 */
private fun solution(food: IntArray): String {
    var answer: String = ""
    val countList = mutableListOf<Int>()
    countList.add(1)

    for( num in 1 until food.size ) {
        countList.add(food[num]/2)
    }

    for( num in 1 until countList.size) {
        for( i in 1..countList[num]) {
            answer += num.toString()
        }
    }
    //println(food.contentToString())

    // food[0] = 물
    answer += "0"

    for( num in countList.size-1 downTo 1 ) {
        for( i in 1..countList[num]) {
            answer += num.toString()
        }
    }

    return answer
}
