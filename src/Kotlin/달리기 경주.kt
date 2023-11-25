package Kotlin

fun main() {
    println(
        solution(
            arrayOf("mumu", "soe", "poe", "kai", "mine"),
            arrayOf("kai", "kai", "mine", "mine")
        ).contentToString()
    )
}

/**
 * Solution
 * 바로 앞의 선수를 추월할 때, 추월한 선수의 이름을 부릅니다.
 * "mumu", "soe", "poe"
 * -> "soe"를 부른다면, "soe"가 "mumu"를 추월하고, 1등이 된 것.
 * "soe", "mumu", "poe"
 *
 * @param players : 선수들의 이름이 1등부터 순서대로 담긴 문자 배열
 * @param callings : 해설진이 부른 이름을 순서대로 담은 배열
 * @return : 경주가 끝났을 때, 선수들을 등수에 따라 순서대로 배열에 담아 return
 */
private fun solution(players: Array<String>, callings: Array<String>): Array<String> {
    var answer: Array<String> = arrayOf<String>()

    if(players.size in 5..50_000 && callings.size in 2..1_000_000) {
        // 현재 선수 별 등수
        val map = hashMapOf<String, Int>()
        for((idx, player) in players.withIndex()) {
            map[player] = idx
        }

        for(call in callings) {
            val grade  = map[call]  // 호출한 사람 등 수
            val frontCall = players[grade!!-1]    // 호출한 사람 앞 사람

            // 추월에 따른 선수 이름 swap
            players[grade -1] = call
            players[grade] = frontCall

            // 선수 이름에 따른 등 수 swap
            map[call] = map[call]!! -1
            map[frontCall] = map[frontCall]!! + 1
        }

        answer = players
    }
    return answer
}
