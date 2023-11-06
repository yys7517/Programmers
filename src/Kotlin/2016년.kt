package Kotlin

import java.util.Calendar

fun main() {
    println( solution(5, 24) )
}
/**
 * 2016년 1월 1일은 금요일
 * 2016년 a월 b일은 무슨 요일인지 리턴하시오.
 *
 * 2016년은 윤년입니다.
 */
private fun solution(a: Int, b: Int): String {
    var answer = ""
    val days = mutableListOf<Int>()
    val weekDays = arrayOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")

    // 2016년 각 월에 말일이 어디까지 있는지 구하기
    val cal = Calendar.getInstance()
    for( i in 0..11 ) {
        cal.set(2016, i,1)
        days.add(cal.getActualMaximum(Calendar.DAY_OF_MONTH))
    }

    val diffMonth = a - 1
    val diffDate = b - 1

    var diffDays = 0
    for(i in 1..diffMonth) {
        diffDays += days[i-1]
    }
    diffDays += diffDate

//    println("diffDays = $diffDays")

    answer = weekDays[diffDays % 7]
    return answer
}