package onboarding

fun solution5(money: Int): List<Int> {
    var change : MutableList<Int> = mutableListOf()
    val coin = listOf(50000, 10000, 5000,1000, 500, 100, 50, 10, 1)

    var remain = money
    for(i in coin){
        change.add(remain/i)
        remain %= i
    }
    return change
}