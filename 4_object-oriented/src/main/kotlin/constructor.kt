class Person4(           // Konstruktor: Person(n: String, age: Int)
    n: String,
    a: Int
) {
    val name = n
    val age = a
}

class Person5(
    val name: String,
    val age: Int
) {
    constructor(name: String) : this(name, 0) { // másodlagos konstruktor, ami meghívja az elsődelegest
        println("$name megszületett!")
    }
}

fun main() {
    val p3 = Person4("József", 25) // példányosítás
    val p4 = Person5("József", 25) // ugyanúgy működik
    val p5 = Person5("Sándor") // a másodlagos konstruktor hívódik
}