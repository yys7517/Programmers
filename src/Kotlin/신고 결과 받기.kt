package Kotlin

fun main() {
    println(
        solution(
            arrayOf("muzi", "frodo", "apeach", "neo"),
            arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),
            2
        ).contentToString()
    )
}

/**
 * Solution
 *
 * @param idArr : 유저 목록
 * @param reportArr : "이용자id 신고한id" 형태의 문자열 배열
 * 예를 들어 "muzi frodo"의 경우 "muzi"가 "frodo"를 신고했다는 의미입니다.
 * 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
 *
 * @param k : 정지 기준이 되는 신고 횟수
 * @return : 각 유저가 처리 결과 메일을 받는 횟수
 */
private fun solution(idArr: Array<String>, reportArr: Array<String>, k: Int): IntArray {
    var answer: IntArray = IntArray(idArr.size) { 0 }

    val userReportedCount = hashMapOf<String, Int>()    // 유저 별 신고당한 횟수
    val reportMap = hashMapOf<String, MutableSet<String>>() // key : 신고 당한 사람 , value : 신고한 사람들
    val idIndexMap = hashMapOf<String, Int>()   //  유저 별 인덱스 맵

    for(idx in idArr.indices) {
        reportMap[idArr[idx]] = mutableSetOf()
        userReportedCount[idArr[idx]] = 0
        idIndexMap[idArr[idx]] = idx
    }

//    println(idIndexMap)

    // key : 신고 당한 사람, value : Set(신고한 사람들)
    for(report in reportArr) {
        val splited = report.split(" ")
        val reporter = splited[0]
        val reported = splited[1]

        reportMap[reported]?.add(reporter)
    }

    // 유저 별 신고 당한 횟수
    reportMap.forEach { entry ->
        userReportedCount[entry.key] = entry.value.size
    }

//    println(userReportedCount)

    val bannedName = mutableListOf<String>()

    userReportedCount.forEach { entry ->
        if(entry.value >= k) {
            bannedName.add(entry.key)
        }
    }

    bannedName.forEach { banned ->
        reportMap[banned]!!.forEach { reporter ->
            answer[idIndexMap[reporter]!!]++
        }
    }

    return answer
}
