import kotlin.random.Random

class Person3(
    public var name: String, // a default láthatóság public, ezt nem muszáj külön kiírni
    public var age: Int,
) {
    private var tajNumber: String = Random.nextInt(111111111, 999999999).toString()
}

fun main() {
    val person = Person3("József", 25)
    println(person.name)
    person.name = "Dezső"
    println(person.age)
    person.age = 28
    //println(person.tajNumber) // ilyet nem lehet csinálni, mert az adott tagváltozó privát
    //person.tajNumber = 123456789 // hasonlóan ilyet sem
}
