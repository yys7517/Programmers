package Kotlin

/**
 * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬
 * 각 문자열의 n번째 인덱스에 있는 문자를 기준으로
 * 오름차순으로 정렬
 * 그 문자를 포함하는 단어를 정렬

 * ex) sun, bed, car , n = 1
 * u, e, a -> a, e, u
 --> car, bed, sun

 * 인덱스 n에 위치한 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
 * ex) abce, abcd, cdx , n = 2
 * c, c, d
 --> abcd, abce, cdx

 */
fun main() {
    println(
        solution(
            arrayOf("sun","bed","car"), 1
        ).contentToString()
    )

    println(
        solution(
            arrayOf("abce","abcd","cdx"), 2
        ).contentToString()
    )

    println(
        solution(
            arrayOf("bc","bcb"), 1
        ).contentToString()
    )

    println("abcd" < "abce")
}

/**
 * 문자열 배열 strings
 * 정수 n
 */
private fun solution(strings: Array<String>, n: Int): Array<String> {
    var answer = arrayOf<String>()
    var sameString = false

    var temp : String
    for(i in 0 until strings.size - 1) {
        for(j in i+1 until strings.size) {
            if(strings[i][n] > strings[j][n]) {
                temp = strings[i]
                strings[i] = strings[j]
                strings[j] = temp
            } else if(strings[i][n] == strings[j][n]) {
                // 인덱스 n에 위치한 문자가 같은 문자열이 여럿 일 경우,
                // 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
                if( strings[i] > strings[j] ) {
                    temp = strings[i]
                    strings[i] = strings[j]
                    strings[j] = temp
                }
            }
        }
    }

    answer = strings

    return answer
}