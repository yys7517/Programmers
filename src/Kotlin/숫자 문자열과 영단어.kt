package Kotlin

/** 숫자 문자열과 영단어
 * 1478 → "one4seveneight"
 * 234567 → "23four5six7"
 * 10203 → "1zerotwozero3"

 * 1 ≤ s의 길이 ≤ 50
 * s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
 */

fun main() {
    println(solution("1oneone23"))
    println(solution("one4seveneight"))
    println(solution("23four5six7"))
    println(solution("2three45sixseven"))
    println(solution("123"))

}

private fun solution(s: String): Int {
    var answer: Int = 0
    val regex = Regex("^[0-9]*")

    var temp = s
    while(!temp.matches(regex)) {
        if(temp.contains("zero")) {
            temp = temp.replace("zero","0")
        }
        if(temp.contains("one")) {
            temp = temp.replace("one","1")
        }
        if(temp.contains("two")) {
            temp = temp.replace("two","2")
        }
        if(temp.contains("three")) {
            temp = temp.replace("three","3")
        }
        if(temp.contains("four")) {
            temp = temp.replace("four","4")
        }
        if(temp.contains("five")) {
            temp = temp.replace("five","5")
        }
        if(temp.contains("six")) {
            temp = temp.replace("six","6")
        }
        if(temp.contains("seven")) {
            temp = temp.replace("seven","7")
        }
        if(temp.contains("eight")) {
            temp = temp.replace("eight","8")
        }
        if(temp.contains("nine")) {
            temp = temp.replace("nine","9")
        }

    }

    answer = temp.toInt()
    return answer
}