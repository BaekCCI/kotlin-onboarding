package onboarding

import kotlin.collections.ArrayDeque

fun solution2(cryptogram: String): String {
    val deque = ArrayDeque<Char>()
    var i = 0
    while(i<cryptogram.length){
        if(deque.isEmpty() || cryptogram[i]!=deque.last()){
            deque.addLast(cryptogram[i])
        }
        else if(cryptogram[i]==deque.last()){
            deque.removeLast()
        }
        i++
    }
    var result = ""
    while(!deque.isEmpty()){
        result+=deque.removeFirst()
    }
    return result
}
