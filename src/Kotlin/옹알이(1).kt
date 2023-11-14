package Kotlin

fun main() {
    solution(arrayOf("aya", "yee", "u", "maa", "wyeoo"))
    solution(arrayOf("ayaye", "uuuma", "ye", "yemawoo", "ayaa"))
}

/**
 * "머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다. 조카는 아직
 * "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다."
 */
private fun solution(babbling: Array<String>): Int {
    var answer: Int = 0

    if(babbling.size in 1..100) {
        for(str in babbling) {
            if(str.length in 1..15) {
                var containBool = true
                val splitList = str.split("aya","ye","woo","ma")
//                println(splitList)
                splitList.forEach {
                    if(it.isNotEmpty()) containBool = false
                }

                if(containBool) answer++
            }
        }
    }

    return answer
}