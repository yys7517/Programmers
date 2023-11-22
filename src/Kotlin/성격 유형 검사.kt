package Kotlin

fun main() {
    println(
        solution(
            arrayOf("AN", "CF", "MJ", "RT", "NA"),
            intArrayOf(5,3,2,7,5)
        )
    )

    println(
        solution(
            arrayOf("TR", "RT", "TR"),
            intArrayOf(7,1,3)
        )
    )
}


/**
 * Solution
 * 지표
 * 1번 지표	라이언형(R), 튜브형(T)
 * 2번 지표	콘형(C), 프로도형(F)
 * 3번 지표	제이지형(J), 무지형(M)
 * 4번 지표	어피치형(A), 네오형(N
 *
 * 지표에 대한 점수
 * 1 -> 앞 지표 3점
 * 2 -> 앞 지표 2점
 * 3 -> 앞 지표 1점
 * 4 -> 0
 * 5 -> 뒤 지표 1점
 * 6 -> 뒤 지표 2점
 * 7 -> 뒤 지표 3점
 *
 * @param survey : 질문
 * @param choices : 지표에 대한 점수
 * @return : 성격 유형
 */
private fun solution(survey: Array<String>, choices: IntArray): String {
    var answer: String = ""

    val resultMap = mutableMapOf(
        'R' to 0, 'T' to 0,
        'C' to 0, 'F' to 0,
        'J' to 0, 'M' to 0,
        'A' to 0, 'N' to 0
    )

    for( idx in survey.indices ) {
        when(choices[idx]) {
            // 매우 비동의 ~ 약간 비동의
            in 1..3 -> {
                val key = survey[idx][0]

                val score = 4 - choices[idx]
                resultMap[key] = resultMap.getOrDefault(key, 0) + score
            }

            // 약간 동의 ~ 매우 동의
            in 5..7 -> {
                val key = survey[idx][1]

                val score = choices[idx] - 4
                resultMap[key] = resultMap.getOrDefault(key, 0) + score
            }
            else -> {
                // 무효
            }
        }
    }

    answer += if( resultMap['R']!! == resultMap['T']!! ) {
        'R'
    } else if( resultMap['R']!! > resultMap['T']!! ) {
        'R'
    } else {
        'T'
    }


    answer += if( resultMap['C']!! == resultMap['F']!! ) {
        'C'
    } else if( resultMap['C']!! > resultMap['F']!! ) {
        'C'
    } else {
        'F'
    }


    answer += if( resultMap['J']!! == resultMap['M']!! ) {
        'J'
    } else if( resultMap['J']!! > resultMap['M']!! ) {
        'J'
    } else {
        'M'
    }

    answer += if( resultMap['A']!! == resultMap['N']!! ) {
        'A'
    } else if( resultMap['A']!! > resultMap['N']!! ) {
        'A'
    } else {
        'N'
    }

    return answer
}