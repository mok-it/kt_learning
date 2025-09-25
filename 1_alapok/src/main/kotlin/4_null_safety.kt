
// Külön típus, aminek lehet null értéke is

val a: Int = null
val b: Int? = null

// Nullable típusoknál külön operátorok

fun safeIncrement( x: Int? ): Int? {
    // Biztonságos hívás (safe call)
    return x?.inc()
}

fun safeLength( s: String? ): Int {
    // Elvis operátor (elvis operator)
    return s?.length ?: 0
}

fun notSoSafeLength( s: String? ): Int {
    // Nem biztonságos hívás (not-null assertion)
    return s!!.length
}

fun safeLength2( s: String? ): Int {
    // Biztonságos kicsomagolás (safe unwrapping)
    if( s != null ){
        return s.length //IDE jelzi a smart cast-ot
    } else {
        return 0
    }
}

//Tipkus előfordulás
fun main(){
    val scoresMap = mapOf( "John" to 45, "Marie" to 63, "James" to 89 )
    val scoreJohn = scoresMap[ "John" ]
    println( "Score of John: ${scoreJohn ?: 0}" )
}