package Kotlin

import kotlin.math.min

fun main() {
    solution("100","2345")
    solution("100","203045")
    solution("100","123450")
    solution("12321","42531")
    solution("5525","1255")

}

/**
 * 두 수 X와 Y의 일치하는 숫자의 조합으로 가장 큰 수를 만들어서 리턴
 * 짝꿍이 없다면 -1 리턴
 * 0이라면 0 리턴
 *
 * 3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다
 */
private fun solution(X: String, Y: String): String {
    var answer = StringBuilder()    // StringBuilder 를 사용하여 시간 단축

    // 1. X와 Y에서 0 ~ 9의 개수
    val countX = countNumStringArr(X)
    val countY = countNumStringArr(Y)

    // 2. 큰 수의 개수부터 확인
    for( i in countX.indices.reversed() ) {
        // 3. 짝꿍이 있다면?
        while (countX[i] >= 1 && countY[i] >= 1) {
            // 개수 소모해주고, 더해준다.
            countX[i]--
            countY[i]--

            answer.append(i)
        }
    }

    // 이미 내림차순으로 정렬되있음
    if(answer.toString() == "") {
        return "-1"
    } else if (answer.toString().startsWith("0")) {
        return "0"
    } else {
        return answer.toString()
    }
}

private fun countNumStringArr( str : String ) : IntArray {
    val ret = IntArray(10)

    for( ch in str ) {
        val num = Character.getNumericValue(ch)
        ret[num]++
    }

    return ret
}
