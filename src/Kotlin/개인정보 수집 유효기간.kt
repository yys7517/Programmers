package Kotlin

fun main() {
    println(
        solution(
            "2022.05.19",
            arrayOf(
                "A 6", "B 12", "C 3"
            ),
            arrayOf(
                "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"
            )
        ).contentToString()
    )

    println(
        solution(
            "2020.01.01",
            arrayOf(
                "Z 3", "D 5"
            ),
            arrayOf(
                "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"
            )
        ).contentToString()
    )

}

/**
 * Solution
 * 모든 달은 28일까지 있다고 가정합니다.
 *
 * @param today : 오늘 일자
 * @param terms : 약관 별 개인 정보를 보관할 수 있는 달 수
 * @param privacies : 개인 정보 보관 일수와 약관의 종류
 * @return : 파기해야할 개인 정보의 번호를 오름차순으로 담아 리턴
 */
private fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()
    val answerList = mutableListOf<Int>()

    // 약관 별 유효 기한 Map
    val termMap = hashMapOf<String, Int>()
    for(term in terms) {
        val termInfo = term.split(" ")

        val type = termInfo[0]
        val deadline = termInfo[1].toInt()

        termMap[type] = deadline
    }

    for(idx in privacies.indices) {
        val privacyInfo = privacies[idx].split(" ")

        val startDate = privacyInfo[0]
        val type = privacyInfo[1]

        val startYear = startDate.split(".")[0].toInt()
        val startMonth = startDate.split(".")[1].toInt()
        val startDay = startDate.split(".")[2].toInt()

        val todayYear = today.split(".")[0].toInt()
        val todayMonth = today.split(".")[1].toInt()
        val todayDay = today.split(".")[2].toInt()

        val diffYear = termMap[type]!! / 12
        val diffMonth = termMap[type]!! % 12

        var expYear = startYear + diffYear
        var expMonth = startMonth + diffMonth
        var expDay = startDay - 1

        if( expMonth > 12 ) {
            expYear += expMonth / 12
            expMonth %= 12
        }

        if(expDay == 0) {
            expMonth -= 1
            expDay = 28
        }

//        println("$expYear.$expMonth.$expDay")

        // today랑 비교
        if( todayYear >= expYear ) {
            if( todayYear > expYear ) {
                answerList.add(idx+1)
            } else {
                // todayYear == expYear
                if( todayMonth >= expMonth ) {
                    if(todayMonth > expMonth) {
                        answerList.add(idx+1)
                    } else {
                        // todayYear == expYear
                        // todayMonth == expMonth
                        if(todayDay >= expDay) {
                            if(todayDay > expDay) {
                                answerList.add(idx+1)
                            }
                        }
                    }
                }
            }
        }
    }

    answer = answerList.toIntArray()

    return answer
}