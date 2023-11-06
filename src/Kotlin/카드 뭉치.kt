package Kotlin

/**
 * cards1과 cards2에서 단어를 뽑을 때는 순서대로 뽑아야하고,
 * 한 번 사용한 단어는 다시 사용할 수 없다.
 */
fun main() {
    println(
        solution(
            arrayOf("i", "drink", "water"),
            arrayOf("want","to"),
            arrayOf("i","want","to","drink","water")
        )
    )

    println(
        solution(
            arrayOf("i", "water", "drink"),
            arrayOf("want","to"),
            arrayOf("i","want","to","drink","water")
        )
    )
}

/**
 * cards1 - ["i", "drink", "water"], 두 번째 카드 뭉치에 순서대로
 * cards2 - ["want", "to"]가 적혀있을 때
 * goal - ["i", "want", "to", "drink", "water"] 순서의 단어 배열
 */
private fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
    var answer: String = ""

    var idx1 = 0
    var idx2 = 0

    val tempArray : Array<String>
    val tempList = mutableListOf<String>()

    for(word in goal) {
        if( cards1.contains(word) ) {
            tempList.add(cards1[idx1++])
        } else {
            tempList.add(cards2[idx2++])
        }
    }

    tempArray = tempList.toTypedArray()

    answer = "Yes"
    for(idx in goal.indices) {
        if(goal[idx] != tempArray[idx]) {
            answer = "No"
        }
    }

    return answer
}