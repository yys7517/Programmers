package Kotlin

fun main() {
    println(
        solution(intArrayOf(1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1))
    )
}

/**
 * Solution
 * 재료는 아래에서부터 위로 쌓인다.
 * 1: 빵
 * 2: 야채
 * 3: 고기
 * (빵 - 야채 - 고기 - 빵) 순서로 쌓인 햄버거만 포장을 합니다.
 * (1 - 2 - 3 - 1)
 *
 * ex) [2, 1, 1, 2, 3, 1, 2, 3, 1]
 *
 * 여섯번째 순서가 쌓였을 때
 * 2, 1, (1, 2, 3, 1) -> 1개
 *
 * 그 이후
 * 2, (1, 2, 3, 1) -> 1개
 *
 * 총 2개 return
 *
 * @param ingredient: 재료 배열
 * @return : 포장하는 햄버거의 개수
 */
private fun solution(ingredient: IntArray): Int {
    var answer: Int = 0

    val list = mutableListOf<Int>()
    val hamburger = listOf(1,2,3,1)

    for( i in ingredient ) {
        list.add(i)
        if( list.size > 3 && list.takeLast(4) == hamburger ) {
            answer++
            for(cnt in 1..4) {
                list.removeLast()
            }
        }
    }

    return answer
}


// Stack 사용한 방법
//private fun solution(ingredient: IntArray): Int {
//    var answer: Int = 0
//
//    var stack = Stack<Int>()
//
//    for( i in ingredient ) {
//        stack.push(i)
//
//        if(stack.size >= 4 && stack.peek() == 1) {
//
//            // val temp = stack
//            // val temp = stack 부분입니다. Kotlin에서 객체는 참조에 의한 전달(Call by Reference)이기 때문에
//            // temp와 stack은 동일한 객체를 가리키게 됩니다. 따라서 temp를 변경하면 stack도 변경되게 됩니다.
//
//            val hamburger = "1231"
//            var tempStr = ""
//
//            // 1. 최상단 4개
//            val temp = stack.toList()
//            for(cnt in 1..4) {
//                tempStr += temp[temp.size - cnt].toString()
//            }
//
//            // 2. 최상단 4개가 햄버거의 재료와 같은지 확인
//            if(tempStr.reversed() == hamburger) {
//                answer++
//
//                // List to Stack
//                stack = Stack()
//                stack.addAll(temp.dropLast(4))
//            }
//        }
//    }
//
//    return answer
//}