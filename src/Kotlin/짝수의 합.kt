fun main() {
    println(solution(4))
}

// 정수 n
// 0 < n <= 1000
// n 이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.
private fun solution(n: Int): Int {
    var answer: Int = 0
    for( i in 2..n) {
        if( i % 2 == 0) {
            answer += i
        }
    }
    return answer
}
