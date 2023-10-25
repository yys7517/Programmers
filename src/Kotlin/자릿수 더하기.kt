fun main() {
    println(solution(123))
    println(solution(987))
}

private fun solution(n: Int): Int {
    val nString = n.toString()
    var answer = 0

    for(element in nString) {
        // Char to Int는 ASCII 값을 반환한다.
        // Character.getNumericValue(char)를 사용하자
        answer += Character.getNumericValue(element)
    }
    return answer
}