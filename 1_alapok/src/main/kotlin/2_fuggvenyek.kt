

// Basic szintax: fun név(paraméter1: típus, paraméter2: típus): visszatérési_típus { ... }
fun add( a: Int, b: Int ): Int {
    return a + b
}

fun add2( a: Int, b: Int ): Int = a + b

fun add3( a: Int, b: Int ) = a + b


// Default paraméter értékek
fun printNameMail( name: String, email: String = "example@example.com" ){
    println("Name: $name, Email: $email")
}


fun main() {
    printNameMail("Alice", "alice@example.com")
    printNameMail("Bob")

    // Név szerinti paraméter átadás
    printNameMail( email = "alice@example.com", name = "Alice" )
}