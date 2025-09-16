

fun main() {

    // Basic szintax: val/var név: típus = érték
    val a: Int = 5
    var b: String = "Hello"

    //a = 10 // Hiba: val nem módosítható

    b = "World" // OK: var módosítható

    val c = 3.14 // Típus automatikus felismerése (Double)

    val sum = "$a + $c = ${a + c}" // String interpoláció

    println(sum)

}