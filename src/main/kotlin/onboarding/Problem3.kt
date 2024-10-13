package onboarding

fun solution3(number: Int): Int {
    var clap = 0
    for(i in 1..number){
        var num = i.toString()
        for(n in num){
            if (n=='3'||n=='6'||n=='9')
                clap++
        }
    }
    return clap
}
