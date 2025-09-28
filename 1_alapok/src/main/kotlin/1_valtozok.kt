

fun main() {

    // Basic szintax: val/var név: típus = érték
    val a: Int = 5
    var b: String = "Hello"

    //a = 10 // Hiba: val nem módosítható

    b = "World" // OK: var módosítható

    val c = 3.14 // Típus automatikus felismerése (Double)

    val sum = "$a + $c = ${a + c}" // String interpoláció

    println(sum)

    //Tömb
    val d = arrayOf( 1, 2, 3, 4)
    
    println( d[ 0 ] )
    d[ 0 ] = 5
    println( d[ 0 ] )

}
