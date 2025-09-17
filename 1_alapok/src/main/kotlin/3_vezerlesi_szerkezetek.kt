fun passed( score: Int ): Boolean {
    if( score < 50 ){
        println("Failed")
        return false
    } else {
        println("Passed")
        return true
    }
}

fun passed2( score: Int ): Boolean {
    if( score < 50 ){
        println("Failed")
    } else {
        println("Passed")
    }
    return score >= 50
}

fun grade( score: Int ): Int{
    if (score >= 85) {
        return 5
    } else if (score >= 70) {
        return 4
    } else if (score >= 55) {
        return 3
    } else if (score >= 40) {
        return 2
    } else {
        return 1
    }
}

fun grade2( score: Int ): Int{
    when{
        score >= 85 -> return 5
        score >= 70 -> return 4
        score >= 55 -> return 3
        score >= 40 -> return 2
        else -> return 1
    }
}

fun grade3( score: Int ): Int = when{
    score >= 85 -> 5
    score >= 70 -> 4
    score >= 55 -> 3
    score >= 40 -> 2
    else -> 1
}

fun grade4( score: Int ): Int {
    when( score ){
        in 85..100 -> return 5
        in 70..84 -> return 4
        in 55..69 -> return 3
        in 40..54 -> return 2
        in 0..39 -> return 1
        else -> {
            println("Invalid score")
            return -1
        }
    }
}

fun main(){

    for( i in 1..5 ){
        print( "$i.: " )
        for( j in 1 .. i ){
            print( "*" )
        }
        println()
    }

    println()

    val numbers = listOf( 3, 5, 7, 9, 11 )

    for( n in numbers ){
        println( n * 2 )
    }

    println()

    var i = 13

    while( i > 1 ){
        println(i)
        if( i % 2 == 0 ){
            i /= 2
        } else {
            i = 3 * i + 1
        }
    }

}