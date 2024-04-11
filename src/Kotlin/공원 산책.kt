package Kotlin

fun main() {
    println(
        solution(
        arrayOf("SOO","OOO","OOO"),
        arrayOf("E 2","S 2","W 1")
        ).contentToString()
    )

    println(
        solution(
            arrayOf("SOO","OXX","OOO"),
            arrayOf("E 2","S 2","W 1")
        ).contentToString()
    )

    println(
        solution(
            arrayOf("OSO","OOO","OXO","OOO"),
            arrayOf("E 2","S 3","W 1")
        ).contentToString()
    )
}

/**
 * Solution
 *
 * @param park : 공원을 나타내는 문자열 배열 park[i] = S, O, X로 이루어져있다.
 * S : 시작 위치
 * O : 이동 가능한 통로
 * X : 장애물
 *
 * @param routes : 동서남북 방향으로 몇 칸 이동할지 (명령)
 * @return : 로봇 강아지가 모든 명령을 수행한 후 위치하는 좌표를 리턴
 *
 * 좌측 상단의 좌표는 (0, 0) 우측 하단의 좌표는 (H-1, W-1)
 */
private fun solution(park: Array<String>, routes: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()

    // 장애물을 지나는 명령은 무시

    val arr = Array(park.size) { CharArray(park[0].length) }
    var row = 0
    var col = 0

    for( i in park.indices ) {
        for( j in park[i].indices ) {
            arr[i][j] = park[i][j]
            // print(arr[i][j]+ " ")

            if(arr[i][j] == 'S') {
                row = i
                col = j
            }
        }
        // println()
    }
    // println("시작점: $row, $col")

    // 주어진 방향으로 이동할 때 공원을 벗어난다면, 명령을 무시하고 다음 명령을 수행
    // 주어진 방향으로 이동 중 장애물을 만난다면, 명령을 무시하고 다음 명령을 수행
    routes.forEach {
        // ex) it = E 2
        val op = it.split(" ")[0]
        val n = it.split(" ")[1].toInt()

        var moveToCol = col
        var moveToRow = row

        var hasHuddle = false

        when(op) {
            "E" -> {
                // 공원을 벗어나지 않을 때만 명령을 시행
                if( col + n < arr[0].size ) {
                    // 이동 중 장애물을 만나는지
                    for( i in 1..n ) {
                        moveToCol++
                        if(arr[moveToRow][moveToCol] == 'X') {
                            hasHuddle = true
                            break
                        }
                    }
                }
            }

            "W" -> {
                // 공원을 벗어나지 않을 때만 명령을 시행
                if( col - n >= 0 ) {
                    // 이동 중 장애물을 만나는지
                    for( i in 1..n ) {
                        moveToCol--
                        if(arr[moveToRow][moveToCol] == 'X') {
                            hasHuddle = true
                            break
                        }
                    }
                }
            }

            "S" -> {
                // 공원을 벗어나지 않을 때만 명령을 시행
                if( row + n < arr.size ) {
                    // 이동 중 장애물을 만나는지
                    for( i in 1..n ) {
                        moveToRow++
                        if(arr[moveToRow][moveToCol] == 'X') {
                            hasHuddle = true
                            break
                        }
                    }
                }
            }

            "N" -> {
                // 공원을 벗어나지 않을 때만 명령을 시행
                if( row - n >= 0 ) {
                    // 이동 중 장애물을 만나는지
                    for( i in 1..n ) {
                        moveToRow--
                        if(arr[moveToRow][moveToCol] == 'X') {
                            hasHuddle = true
                            break
                        }
                    }
                }
            }

            else -> {}
        }

        // 장애물을 만나지 않았을 때만 이동 경로를 갱신
        if(!hasHuddle) {
            row = moveToRow
            col = moveToCol
        }
    }

    answer = intArrayOf(row, col)
    return answer
}