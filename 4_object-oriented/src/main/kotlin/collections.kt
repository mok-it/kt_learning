class Personn(val name: String, val age: Int)

fun main() {
    val list = listOf("a", "b", "c")

// elem keresése index szerint
    println(list[0]) // "a"
    println(list[1]) // "b"
// adott elem indexének megkeresése
    println(list.indexOf("c")) // 2

    val patients = mapOf(
        "111222333" to Personn("József", 25),
        "123456789" to Personn("Béla", 37)
    )
    println(patients["111222333"]?.name ?: "Nincs 111222333 tajszámú páciens")
}