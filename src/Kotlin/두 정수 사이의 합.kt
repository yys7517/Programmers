package Kotlin

/**
 * 두 정수 a,b
 * a와 b사이의 정수들의 합을 구하시오.
 * ex) a=3, b=5 --> 3+4+5 = 12
 * a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
 * a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
 * a와 b의 대소관계는 정해져있지 않습니다.
 */

fun main() {

}

private fun solution(a: Int, b: Int): Long {
    var answer: Long = 0
    if( a > b ) {
        for( i in b..a ) {
            answer += i.toLong()
        }

    } else if( b > a ){
        for( i in a..b ) {
            answer += i.toLong()
        }
    } else {
        // a와 b가 같은 경우
        answer = a.toLong()
    }
    return answer
}