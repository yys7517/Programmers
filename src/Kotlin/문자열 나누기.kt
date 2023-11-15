package Kotlin

fun main() {
    println(solution("aaabb"))
    println(solution("banana"))
    println(solution("abracadabra"))
    println(solution("aaabbaccccabba"))
}

/**
 * 문자열 s를 다음 규칙에 따라 분해

 규칙
 * 첫 문자를 x
 * x와 x가 아닌 다른 문자들의 개수
 * ex) banana -> [1,5]
 *
 * 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리
 * s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
 *
 * 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
 */
private fun solution(s: String): Int {
        var answer: Int = 0
        var str = StringBuilder(s)

        while(str.isNotEmpty()) {
            val x = str[0]

            var xCount = 1
            var otherCount = 0

            if(str.length == 1) {
                answer++
                break
            } else {
                for( i in 1 until str.length) {
                    if(str[i] == x) xCount++
                    else {
                        otherCount++

                        if( xCount == otherCount ) {
                            answer++

                            str = str.delete(0, i+1)
                            break
                        }
                    }
                }
            }

            // 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
            if(xCount != otherCount) {
                answer++
                break
            }
        }

    return answer
}