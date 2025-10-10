data class Person (
    val name: String,
    val pets: List<Pet>
)
data class Pet (
    val name: String,
    val type: String
)

fun main() {
    val people = listOf(
        Person("József", listOf(
            Pet("Rex", "Kutya")
        )),

        Person("Irma", listOf(
            Pet("Frakk", "Kutya"),
            Pet("Lukrécia", "Macska"),
            Pet("Szerénke", "Macska"),
        )),

        Person("Géza", listOf()),

        Person("Ödön", listOf(
            Pet("Gertrúd", "Rövidcsőrű hangyász"),
            Pet("Pöttöm", "Ékszerteknős"),
            Pet("Matilda", "Madárpók"),
            Pet("Perec", "Kobra"),

        )),

        Person("Mátyás", listOf(
            Pet("Gedeon", "Lúd"),
            Pet("Pipacs", "Lúd"),
            Pet("Csárdás", "Lúd"),
            Pet("Kacér", "Lúd"),
            Pet("Mazsola", "Lúd"),
            Pet("Bimbó", "Lúd"),
        ))
    )

//    println(
//        people.sortedBy { person ->
//            person.pets
//                .map { it.type }
//                .distinct().maxOfOrNull { t ->
//                    person.pets.count { it.type == t }
//                }
//        }.reversed().first().name
//    )

    // Név szerinti sorrend
    println(
        people.sortedBy { it.name }
    )
    // Név szerinti sorrend, de csak a nevek
    println(
        people.map { it.name }.sorted()
    )
    // Állatok száma szerinti sorrend
    println(
        people.sortedBy { it.pets.size }
    )

    // Állatok száma szerinti csökkenő sorrend
    println(
        people.sortedBy { it.pets.size }.reversed()
    )

    // Állattal rendelkezők neve
    println(
        people.filter { it.pets.isNotEmpty() }.map { it.name }
    )

    // Az összes kutya neve
    println(
        people.flatMap { it.pets }.filter { it.type == "Kutya" }.map { it.name }
    )

    // Legtöbb különböző fajta állattal rendelkező ember neve
    println(
        people.sortedBy { it.pets.map { it.type }.distinct().size }.reversed().first().name
    )
}