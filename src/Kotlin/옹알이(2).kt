package Kotlin

fun main() {
    solution(arrayOf("aya","yee","u","maa"))
    solution(arrayOf("ayaye","uuu","yeye","yemawoo","ayaayaa"))
    solution(arrayOf("ayayewoomaayayewooma"))
}

/**
 * ayaaya or yeye or mama와 같이 연속하여 발음하는 것을 못함
 * ayayewooma + ayayewooma 는 가능
 */
private fun solution(babbling: Array<String>): Int {
    var answer: Int = 0
    val temp = arrayOf("aya","ye","woo","ma")


    if( babbling.size in 1..100 ) {
        for(str in babbling) {
            if(str.length in 1..30) {
                // 연속된 발음이 있다면?
                if( str.contains("ayaaya") || str.contains("yeye")
                    || str.contains("woowoo") || str.contains("mama") ) {
                    continue
                }

                var containBool = true

                // 연속된 발음이 없을 때
                val splitList = str.split("aya","ye","woo","ma")
//                println(splitList)

                splitList.forEach {
                    if(it.isNotEmpty()) containBool = false
                }

                if(containBool) answer++
            }
        }

//        println(answer)
    }
    return answer
}