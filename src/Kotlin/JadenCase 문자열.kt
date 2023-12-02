package Kotlin


//private fun solution(s: String): String {
//    val answer = s.split(" ").map {
//        if(it.isNotEmpty()) {
//            val chArr = it.lowercase().toCharArray()
//            chArr[0] = chArr[0].uppercaseChar()
//            String(chArr)
//        }
//        else{
//            it
//        }
//    }.joinToString(" ")
//
//    return answer
//}

private fun solution(s: String): String {
    return s.split(" ").joinToString(" ") { str ->
        str.lowercase()
            .replaceFirstChar { it.uppercaseChar() }
    }
}
fun main() {
    println(solution("a b  unFollowed"))
    println(solution("3people unFollowed me"))
    println(solution("for the last week"))
}