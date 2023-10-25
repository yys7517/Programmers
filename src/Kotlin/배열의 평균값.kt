fun main() {
    println(solution(intArrayOf(1,2,3,4,5,6,7,8,9,10)))
    println(solution(intArrayOf(89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99)))
}

private fun solution(numbers: IntArray): Double {
    var total = 0
    for( i in numbers) {
        total += i
    }
    val answer = total.toDouble() / numbers.size
    return answer
}