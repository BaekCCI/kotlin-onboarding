package onboarding

import kotlin.math.*

fun checkException(list: List<Int>) :Boolean{
    if(list[0]>list[1] || abs(list[0]-list[1])!=1){
        return false
    } else return true
}
fun getNum(list : List<Int>) : Int{
    var num = list[0].toString()
    var sum = 0
    var multi = 1
    for (n in num){
        sum += n.toString().toInt()
        multi *= n.toString().toInt()
    }
    val left = max(sum, multi)

    num = list[1].toString()
    sum = 0
    multi = 1
    for (n in num){
        sum += n.toString().toInt()
        multi *= n.toString().toInt()
    }
    val right = max(sum, multi)
    return max(left, right)
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!checkException(pobi) || !checkException(crong)) return -1
    else{
        if(getNum(pobi) > getNum(crong)) return 1
        else if(getNum(pobi) < getNum(crong)) return 2
        else return 0
    }
}
