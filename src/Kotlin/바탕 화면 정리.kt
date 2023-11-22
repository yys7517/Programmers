package Kotlin

fun main() {

    solution(
        arrayOf(".#...", "..#..", "...#.")
    )

    solution(
        arrayOf("..........", ".....#....", "......##..", "...##.....", "....#.....")
    )

    solution(
        arrayOf(".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#....")
    )

    solution(
        arrayOf("..", "#.")
    )
}

/**
 * Solution
 *
 * @param wallpaper : 바탕 화면 배치도, .을 빈칸, #이 파일이 위치한 칸
 * @return : 모든 파일을 마우스로 드래그 할 수 있는 최소 크기의 시작 점 좌표와 끝 점 좌표를 리턴
 * ex) (0,1) , (3,4) -> [0, 1, 3, 4]
 */
private fun solution(wallpaper: Array<String>): IntArray {
    val answer = IntArray(4) { 0 }

//    val start = arrayOf(0,0)
//    val end = arrayOf(0,0)

/*
    val matrix = Array(wallpaper.size) { Array(wallpaper[0].length) { "" } }

    // 2차원 배열 그리기
    for( i in wallpaper.indices ) {
        for(j in wallpaper[i].indices) {
           matrix[i][j] = wallpaper[i][j].toString()
            print("${matrix[i][j]} ")
        }
        println()
    }
*/

    // 1. 시작점 찾기 (가장 위에 있는 # 찾기)
    for( row in 0 until wallpaper.size) {
        if(wallpaper[row].contains("#")) {
//            start[0] = row
            answer[0] = row
            break
        }
    }

    // 1-1. 시작점 찾기 (가장 왼쪽에 있는 # 찾기)
    val leftList = mutableListOf<Int>()
    for( row in 0 until wallpaper.size) {
        val locate = wallpaper[row].indexOf('#')
        if(locate != -1) {
            leftList.add(locate)
        }
    }

    // 2. 끝 점 찾기 (가장 아래에 있는 # 찾기)
    for( row in wallpaper.size - 1 downTo 0) {
        if(wallpaper[row].contains("#")) {
//            end[0] = row + 1
            answer[2] = row + 1
            break
        }
    }

    // 2-1. 끝 점 찾기 (가장 오른쪽에 있는 # 찾기)
    val rightList = mutableListOf<Int>()
    for( row in wallpaper.size - 1 downTo 0) {
        val locate = wallpaper[row].lastIndexOf('#')
        if(locate != -1) {
            rightList.add(locate + 1)
        }
    }

    // 가장 왼쪽에 있는 #을 찾으려면, #이 위치하는 첫 번째 인덱스 중에 최소값
    leftList.sort()
//    start[1] = leftList[0]
    answer[1] = leftList[0]

    // 가장 오른쪽에 있는 #을 찾으려면, #이 위치하는 마지막 인덱스 중에 최댓값
    rightList.sortDescending()
//    end[1] = rightList[0]
    answer[3] = rightList[0]

//    println(start.contentToString())
//    println(end.contentToString())

    return answer
}