package onboarding

fun solution6(forms: List<List<String>>) : List<String> {
    var list : MutableList<MutableList<String>> = mutableListOf()
    var result : MutableSet<String> = mutableSetOf()

    for (form in forms){
        var name = form[1]
        var email = form[0]

        for( i in 0..name.length-2){
            var subName = name.substring(i,i+2)
            if(!list.isEmpty()){
                for(item in list){
                    if(item[0]==subName){
                        result.add(email)
                        result.add(item[1])
                    }
                }
            }
            list.add(mutableListOf(subName,email))
        }
    }
    return result.sorted()
}
