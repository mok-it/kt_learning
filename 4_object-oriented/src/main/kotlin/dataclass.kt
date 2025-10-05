import java.time.LocalDate

data class Email(
    val sender: String,
    val recipient: String,
    val title: String,
    val message: String,
    val sendDate: LocalDate
)

fun main() {
    val e1 = Email(
        "mate@example.com",
        "laci@example.com",
        "Hello",
        "Szia",
        LocalDate.of(2025, 10, 5)
    )
    println(e1) // értelmes formátumban kerül kiírásra az objektum (nem dataclass esetén ez nem ilyen szép)

    val e2 = Email(
        "mate@example.com",
        "laci@example.com",
        "Hello",
        "Szia",
        LocalDate.of(2025, 10, 5)
    )

    // true, mert ha data class objektumainak minden mezője megegyezik, akkor egyenlőek
    // (Person esetén pl. nem, lehetnek különböző emberek ugyanazzal a névvel, szül. dátummal, stb.)
    println(e1 == e2)

    val e3 = e1.copy(recipient = "tomi@example.com") // másolás, csak néhány mező felülírása
}