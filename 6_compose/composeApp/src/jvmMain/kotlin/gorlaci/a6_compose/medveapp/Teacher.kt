package medveapp

import java.time.LocalDate

class Teacher(
    name: String,
    tShirtSize: TShirtSize,
    birthDate: LocalDate,
    val favoriteThematic: String = "Gráfelmélet",
) : Person(name, tShirtSize, birthDate)