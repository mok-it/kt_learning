class Car2 {
    val wheels = 4

    fun printWheels() { // nem kapja meg a tagváltozót paraméterként, de tud rá hivatkozni, mert az osztályon belüli
        println(wheels)
    }
}

fun main() {
    Car2().printWheels()
}