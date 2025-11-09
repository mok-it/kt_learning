package medveapp

import java.time.LocalDate
import kotlin.random.Random

class Student(
    name: String,
    tShirtSize: TShirtSize,
    birthDate: LocalDate
) : Person(name, tShirtSize, birthDate) {
    val learnedThematics = mutableListOf<String>()
    val ownedTShirts = mutableListOf<TShirt>()

    fun buyTShirt(camp: Camp) {
        val batka = Random.nextInt(0, 8000)
        if (batka >= 1000) {
            println("$name kapott pólót!")
            ownedTShirts.add(TShirt(tShirtSize, camp.year))
        }
    }

}