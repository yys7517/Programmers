package Kotlin

fun main() {
    println(solution(intArrayOf(-2,3,0,2,-5)))
    println(solution(intArrayOf(-3,-2,-1,0,1,2,3)))
    println(solution(intArrayOf(-1,1,-1,1)))
}

private fun solution(number: IntArray): Int {
    var answer: Int = 0
    for( i in 0 until number.size -2 ) {
        for( j in i+1 until number.size) {
            for( k in j+1 until number.size ) {
                if( number[i] + number[j] + number[k] == 0 ) {
                    answer++
                }
            }
        }
    }
    return answer
}