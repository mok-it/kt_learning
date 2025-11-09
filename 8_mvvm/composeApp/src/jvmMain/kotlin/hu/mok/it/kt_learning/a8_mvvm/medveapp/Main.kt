package medveapp

import java.time.LocalDate

fun main() {

    val karoly = Student("Nagy Károly", TShirtSize.M, LocalDate.of(2013, 8, 11))
    val geza = Student("Kis Géza", TShirtSize.L, LocalDate.of(2012, 4, 21))
    val jani = Teacher("János", TShirtSize.M, LocalDate.of(-5, 11, 15))
    val panko = Teacher("Anna", TShirtSize.S, LocalDate.of(1997, 2, 21))
    val szuli = Teacher("Gábor", TShirtSize.S, LocalDate.of(1992, 9, 11))

    val s1_24 = Camp("Sástó", 2024, panko, 1)
    val s1 = Camp("Sástó", 2025, panko, 1)
    val pf = Camp("Pusztafalu", 2025, szuli)

    s1_24.applyStudent(karoly)
    s1_24.applyTeacher(panko, "Vegyes feladatok")

    println("S1 24:")
    s1_24.go()

    println(s1_24.accomodationReport())
    println(karoly.learnedThematics)

    s1.applyStudent(karoly)
    s1.applyStudent(geza)
    s1.applyTeacher(panko, "Szerkesztések")
    s1.applyTeacher(jani, "Bizonyítási módszerek")

    println("S1:")
    s1.go()

    println(s1.accomodationReport())
    println(karoly.learnedThematics)

    pf.applyStudent(karoly)
    pf.applyTeacher(szuli, "Gazdaság")
    pf.applyTeacher(panko, "Gömbi geometria")
    println(pf.accomodationReport())

    println("PF:")
    pf.go()

    println(pf.accomodationReport())
    println(karoly.learnedThematics)
    println(karoly.ownedTShirts)
}