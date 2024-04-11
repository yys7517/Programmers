package Kotlin

/**
 * 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
 *
 * x의 모든 0을 제거합니다.
 * x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
 * 예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
 *
 * 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * s : "0111010" -> "1111" -> "100"
 * s : "100" -> 1"
 * return [2, 5]
 *
 * s : "110010101001" -> "111111" -> "110"
 * s : "110" -> "11" -> "10"
 * s : "10" -> "1"
 * return [3, 8]
 */
private fun solution(s: String): IntArray {
    var answer: IntArray = intArrayOf()
    var temp = s
    var zeroCount = 0

    var calcCount = 0

    while( temp != "1" ) {
        print("$temp -> ")
        calcCount++

        // 1. s의 0의 개수 구하기
        zeroCount += temp.count { it == '0' }

        // 2. 0을 제거한 값으로 변경
        temp = temp.filter { it == '1' }
        print("$temp -> ")

        // 2. s에서 0을 제거한 길이를 구해서
        var num = temp.length

        // 3. 길이 값을 이진 변환한 결과 값을 temp에 다시 대입
        var result = ""
        while(num > 0) {
            result = (num % 2).toString() + result
            num /= 2
        }

        temp = result
        println(temp)
    }

    answer = intArrayOf(calcCount, zeroCount)
    return answer
}

fun main() {
//    println("110010101001".count { it == '0' })
    println("110010101001".filter { it == '1' })

    println(
        solution("110010101001").contentToString()
    )
}