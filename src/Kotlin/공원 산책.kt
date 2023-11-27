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

    var x = 0
    var y = 0

    val arr = Array(park.size) { CharArray(park[0].length) }
    for( i in park.indices ) {
        for(j in park[i].indices) {
            arr[i][j] = park[i][j]
//            print("${arr[i][j]} ")
            if( arr[i][j] == 'S' ) {
                // 시작점
                x = i
                y = j
            }
        }
//        println()
    }

//    println("시작점 : $x, $y")

    val width = park[0].length
    val height = park.size

    for( route in routes ) {
        val routeInfo = route.split(" ")
        val op = routeInfo[0]
        val n = routeInfo[1].toInt()

        var hasHuddle = false
        // 주어진 방향으로 이동할 때 공원을 벗어난다면, 명령을 무시하고 다음 명령을 수행
        // 주어진 방향으로 이동 중 장애물을 만난다면, 명령을 무시하고 다음 명령을 수행
        when(op) {
            "W" -> {
                var tempY = y
                // 공원을 벗어나지 않고
                if(y-n in 0..width-1) {
                    // 경로에 장애물이 있는지
                    for(i in 1..n) {
                        tempY -= 1
                        if( park[x][tempY] == 'X' ) {
                            hasHuddle = true
                        }
                    }

                    if(!hasHuddle) y = tempY
                }
            }
            "E" -> {
                var tempY = y
                // 공원을 벗어나지 않고
                if(y+n in 0..width-1) {
                    // 경로에 장애물이 있는지
                    for(i in 1..n) {
                        tempY += 1
                        if( park[x][tempY] == 'X' ) {
                            hasHuddle = true
                        }
                    }

                    if(!hasHuddle) y = tempY
                }
            }
            "S" -> {
                var tempX = x
                // 공원을 벗어나지 않고
                if(x+n in 0..height-1) {
                    // 경로에 장애물이 있는지
                    for(i in 1..n) {
                        tempX += 1
                        if( park[tempX][y] == 'X' ) {
                            hasHuddle = true
                        }
                    }

                    if(!hasHuddle) x = tempX
                }
            }
            else -> {
                var tempX = x
                // 공원을 벗어나지 않고
                if(x-n in 0..height-1) {
                    // 경로에 장애물이 있는지
                    for(i in 1..n) {
                        tempX -= 1
                        if( park[tempX][y] == 'X' ) {
                            hasHuddle = true
                        }
                    }

                    if(!hasHuddle) x = tempX
                }
            }
        }
    }

    answer = intArrayOf(x, y)
    return answer
}