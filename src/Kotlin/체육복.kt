package Kotlin

/**
 * 체육복 - 그리디 알고리즘
 *
 * 여벌의 체육복은 자신의 앞 뒤 번호에게만 빌려줄 수 있음.
 * 3번 학생이 체육복을 가지고 있다 -> 2번 or 4번 학생에게 빌려줄 수 있음.
 */

fun main() {
    println(
        solution(5, intArrayOf(2,4), intArrayOf(1,3,5))
    )

    println(
        solution(5, intArrayOf(2,4), intArrayOf(3))
    )

    println(
        solution(3, intArrayOf(3), intArrayOf(1))
    )
}

/**
 * n : 전체 학생의 수
 * lost : 체육복을 도난당한 학생들의 번호
 * reserve : 여벌의 체육복을 가지고 있는 학생들의 번호
 *
 * 체육 수업을 들을 수 있는 학생의 최댓값을 리턴
 */
private fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    var answer = n - lost.size

    lost.sort()
    reserve.sort()

    // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
    for( i in lost.indices ) {
        if( lost[i] < 0 ) continue

        for( j in reserve.indices ){
            if( reserve[j] < 0 ) continue

            if(lost[i] == reserve[j]) {
                lost[i] = -1
                reserve[j] = -1
                answer++
                break
            }
        }
    }

    for( i in lost.indices ) {
        if( lost[i] < 0 ) continue

        for( j in reserve.indices ){
            if( reserve[j] < 0 ) continue

            if(lost[i] == reserve[j] -1 || lost[i] == reserve[j] + 1) {
                lost[i] = -1
                reserve[j] = -1
                answer++
                break
            }
        }
    }


    return answer
}