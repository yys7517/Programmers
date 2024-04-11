package Kotlin

fun main() {
    solution(
        arrayOf("muzi", "ryan", "frodo", "neo"),
        arrayOf("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi")
    )

    solution(
        arrayOf("joy", "brad", "alessandro", "conan", "david"),
        arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david")
    )

    solution(
        arrayOf("a", "b", "c"),
        arrayOf("a b", "b a", "c a", "a c", "a c", "c a")
    )
}

private fun solution(friends: Array<String>, gifts: Array<String>): Int {
    val records = hashMapOf<String, HashMap<String, Int>>()
    val scores = hashMapOf<String, Int>()   // 선물 지수
    val nextGifts = hashMapOf<String, Int>()    // 다음 달 받을 선물 개수

    friends.forEach {
        records[it] = hashMapOf()
        scores[it] = 0
        nextGifts[it] = 0
    }

    gifts.forEach {
        val sender = it.split(" ")[0]
        val receiver = it.split(" ")[1]

        if(records[sender]!![receiver] == null) records[sender]!![receiver] = 0

        // sender의 선물을 보낸 정보
        records[sender]!![receiver] = records[sender]!![receiver]!! + 1 // sender가 receiver에게 선물 보낸 횟수 + 1

        // 선물 지수 = 자신이 준 선물의 수 - 자신이 받은 선물의 수
        scores[sender] = scores.getOrDefault(sender, 0) + 1
        scores[receiver] = scores.getOrDefault(receiver, 0) - 1

//        println(records)
//        println(scores)
    }

//    println(records)
    for( sender in friends ) {
        for( receiver in friends ) {
            if(sender == receiver) continue

            val sToR = records[sender]!!.getOrDefault(receiver, 0)
            val rToS = records[receiver]!!.getOrDefault(sender, 0)

            /**
             * 보낸 사람만 선물 개수를 더해준다.
             * Why? 받는 사람도 같이 처리해주면, 나중에 중복되서 처리되기 때문
             * ex) sender: muji
             * receiver: frodo
             *
             * 이 때, frodo가 보낸 선물이 더 많다고 가정했을 때, frodo가 다음에 받을 선물의 개수를 더해주면
             * sender가 frodo가 되었을 때도, frodo가 다음에 받을 선물의 개수는 더해진다. (중복)
             */
            if( sToR > rToS ) { // 선물을 주고 받은 적이 있다면, 높은 사람이 선물을 받는다.
                nextGifts[sender] = nextGifts.getOrDefault(sender, 0) + 1
            } else if( sToR == rToS ) { // 선물을 주고 받은 적이 없거나, 주고 받은 횟수가 서로 같다면
                if (scores[sender]!! == scores[receiver]!!) continue

                if( scores[sender]!! > scores[receiver]!!) {
                    nextGifts[sender] = nextGifts.getOrDefault(sender, 0) + 1
                }
            }
        }
    }

    // 선물을 가장 많이 받는 친구가 받는 선물의 수: answer
    //    print(nextGifts)
    // 선물을 가장 많이 받는 친구가 받는 선물의 수: answer
    //    print(nextGifts)
    var answer = 0 /*nextGifts.values.max()*/
    nextGifts.values.forEach {
        if(it > answer) answer = it
    }

    println(answer)
    return answer
}