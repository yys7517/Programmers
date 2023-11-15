package Kotlin

import kotlin.math.min

fun main() {
    solution(
        arrayOf("ABACD", "BCEFD"),
        arrayOf("ABCD", "AABB")
    )

    solution(
        arrayOf("AA"),
        arrayOf("B")
    )

    solution(
        arrayOf("AGZ", "BSSS"),
        arrayOf("ASA", "BGZ")
    )

//    for(i in 'A'..'Z') {
//        println(i.code)
//    }
}

/**
 * 1 ≤ keymap의 길이 ≤ 100
 * keymap[i]는 i + 1번 키를 눌렀을 때 순서대로 바뀌는 문자를 의미합니다.
 * 예를 들어 keymap[0] = "ABACD" 인 경우 1번 키를 한 번 누르면 A, 두 번 누르면 B, 세 번 누르면 A 가 됩니다.
 *
 * 같은 문자가 자판 전체에 여러 번 할당된 경우도 있고 ( ex) "ABACD" A를 얻어내기 위해서는 최소 1번 누르면 된다. )
 * 키 하나에 같은 문자가 여러 번 할당된 경우도 있습니다.
 * keymap의 원소는 알파벳 대문자로만 이루어져 있습니다.
 * ( A~Z, ASCII 65 ~ 90 )
 * 목표 문자열을 작성하기 위해 자판을 최소 몇 번 눌러야 하는지 값을 리턴
 * 심지어 아예 할당되지 않은 경우도 있으므로, 목표 문자열을 작성할 수 없을 때는 -1을 리턴
 */

private fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()
    val answerList = mutableListOf<Int>()

    // 자판에서 특정 문자를 입력하기 위해서 최소 눌러야 할 횟수
    // 특정 문자를 입력할 수 없을 경우 횟수를 -1로 초기화한다.
    val counts = IntArray(26) { -1 }

    for( key in keymap ) {
        for( ch in key ) {
            val locate = key.indexOf(ch)

            // 자판에서 특정 문자를 완성하기 위해 누를 횟수 = locate + 1
            if(counts[ch.code-65] == -1 )
                counts[ch.code - 65] = locate + 1
            else
                counts[ch.code-65] = min(counts[ch.code-65], locate + 1)
        }
    }
//    println(counts.contentToString())

    for( target in targets ) {
        var count = 0

        for(ch in target) {
            val keyCount = counts[ch.code - 65]   // 특정 문자 ch를 완성하기 위해 최소 누를 횟수

            if( keyCount != -1) {   // 완성할 수 있는 문자
                count += keyCount
            } else {    // 완성할 수 없는 문자
                count = -1
                break
            }
        }

        answerList.add(count)
    }

    answer = answerList.toIntArray()
    return answer
}