fun main() {

}

private fun solution(arr: IntArray): Double {
    var total = 0
    for( i in arr) {
        total += i
    }
    val answer : Double = total.toDouble() / arr.size
    return answer
}