package Kotlin

fun main() {
    println(solution("zzzz", "abcd",1))
}

/**
 * Solution
 *
 * @param s : 문자열 s
 * @param skip : skip할 문자열
 * @param index : 문자열 s를 index 값만큼 이동한다.
 * @return
 */
private fun solution(s: String, skip: String, index: Int): String {
    var answer: String = ""

    for(ch in s) {
        var temp = ch
        for(i in 1..index) {
            temp += 1
            while( skip.contains(temp) ) {
                temp += 1
            }
            if(temp.code > 'z'.code) {
                temp -= 26

                while( skip.contains(temp) ) {
                    temp += 1
                }
            }
        }

        answer += temp
    }
    return answer
}