package onboarding

fun solution4(word: String): String {
    var result = ""

    for(ch in word){
        if(ch in 'A'..'Z'){
            result+=(155-ch.code).toChar()
        }
        else if(ch in 'a'..'z'){
            result+=(219-ch.code).toChar()
        }
        else result+=ch
    }
    return result
}