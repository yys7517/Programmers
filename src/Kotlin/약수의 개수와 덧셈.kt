package Kotlin

fun main() {
    println(solution(13,17))
    println(solution(24,27))
}

private fun solution(left: Int, right: Int): Int {
    var answer: Int = 0

    for( number in left..right ) {
        var count = 0
        for( i in 1..number) {
            if( number % i == 0 ) count ++
        }

        if( count % 2 == 0 ) {
            answer += number
        } else {
            answer -= number
        }
    }

    return answer
}