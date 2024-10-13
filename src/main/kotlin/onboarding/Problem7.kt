package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val friendMap = mutableMapOf<String, MutableSet<String>>()
    val scoreMap = mutableMapOf<String,Int>()
    for (friend in friends){
        friendMap.putIfAbsent(friend[0], mutableSetOf()) // friend[0]이 존재X -> friendMap에 추가
        friendMap.putIfAbsent(friend[1], mutableSetOf())

        friendMap[friend[0]]?.add(friend[1])
        friendMap[friend[1]]?.add(friend[0])
        // 위 코드와 아래 코드 동일.
//        friendMap.computeIfAbsent(friend[0]){ mutableSetOf() }.add(friend[1])
//        friendMap.computeIfAbsent(friend[1]){ mutableSetOf() }.add(friend[0])
    }

    friendMap[user]?.forEach {
        friendMap[it]?.forEach{ isFriend ->
            if(isFriend!=user && !friendMap[user]?.contains(isFriend)!!){
                if(scoreMap.contains(isFriend)){
                    scoreMap[isFriend] = scoreMap[isFriend]!! + 10
                }else{
                    scoreMap[isFriend] = 10
                }
            }
        }
    }
    println(friendMap)
    println(scoreMap)
    visitors.forEach{
        if(!friendMap[user]?.contains(it)!!){
            if(scoreMap.contains(it)){
                scoreMap[it] = scoreMap[it]!! + 1
            }else{
                scoreMap[it] = 1
            }
        }
    }
    println(scoreMap)
    val result = scoreMap
        .filter { it.value>0 }
        .toList()
        .sortedBy { it.first }
        .sortedByDescending { it.second }
        .map{it.first}


    return result

}


//fun main(){
//    val friends = listOf(
//        listOf("donut", "andole"),
//        listOf("donut", "jun"),
//        listOf("donut", "mrko"),
//        listOf("shakevan", "andole"),
//        listOf("shakevan", "jun"),
//        listOf("shakevan", "mrko")
//    )
//    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
//    print(solution7("andole", friends, visitors))
//}