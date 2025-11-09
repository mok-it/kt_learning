package medveapp

import java.time.LocalDate
import kotlin.math.absoluteValue
import kotlin.random.Random

abstract class Person(
    val name: String,
    val tShirtSize: TShirtSize,
    val birthDate: LocalDate
) {
    val personalID = Random.nextInt(111111, 999999).toString() + randomChars()

    private fun randomChars(): String {
        val letters = listOf("A", "B", "C", "D", "E", "F")
        return letters[Random.nextInt().absoluteValue % 5] + letters[Random.nextInt().absoluteValue % 5]
    }
}