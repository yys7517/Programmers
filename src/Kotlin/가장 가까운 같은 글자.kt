package Kotlin

fun main() {
    println(
        solution("bababa").contentToString()
    )

    println(
        solution("banana").contentToString()
    )

    println(
        solution("foobar").contentToString()
    )

    println(
        solution("abcda").contentToString()
    )
}

/**
 * 문자열 s
 * 각 문자마다 자신보다 앞에 나왔으면서 자신과 가장 가까운 곳에 있는 같은 글자가 어디있는지
 * ex) s = "banana"
b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
 */
private fun solution(s: String): IntArray {
    var answer: IntArray = intArrayOf()
    val answerList = mutableListOf<Int>()

    for( i in s.indices ) {
        if( i == 0 ) {
            answerList.add(-1)
            continue
        }

        var count = 0
        var find = false
        for(j in i-1 downTo(0)) {
            count++
            if(s[j] == s[i]) {
                answerList.add(count)
                find = true
                break
            }
        }
        if( find ) continue
        else answerList.add(-1)
    }

    answer = answerList.toIntArray()
    return answer
}