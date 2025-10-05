package medveapp

import java.time.LocalDate

class Teacher(
    name: String,
    tShirtSize: TShirtSize,
    birthDate: LocalDate
) : Person(name, tShirtSize, birthDate)