fun <T> List<String>.myMap(transform: (String) -> T): List<T> {
    val result = mutableListOf<T>()
    for (i in this) {
        result.add(transform(i))
    }
    return result
}

fun main() {
    val myLambda: (String) -> Int = { x: String -> x.length }
    val l = listOf("a", "bc", "def")

    println(
        l.myMap { it.length }
    )

    println(
        l.myMap { it.last() }
    )
}