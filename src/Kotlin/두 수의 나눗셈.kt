fun main() {
    println( solution(1, 16) )
}

private fun solution(num1: Int, num2: Int): Int {
    val divide = num1.toDouble() / num2
    return (divide * 1000).toInt()
}
