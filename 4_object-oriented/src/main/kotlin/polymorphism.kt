open class Vehicle { // open class, ebből le lehet származni.
    open fun getName(): String { //open függvényt lehet csak felülírni leszármazottban
        return "Jármű"
    }
}

class Bicycle : Vehicle() {
    override fun getName(): String { //override kulcsszó: ősben definiált metódus felülírása
        return "Bicikli"
    }

    fun pedal() {
        println("This is tiring...")
    }
}

class Car : Vehicle() {
    override fun getName(): String {
        return "Autó"
    }
}

fun main() {

    val bike: Bicycle = Bicycle()
    bike.pedal()
    var secretlyABike: Vehicle = Bicycle()
    //secretlyABike.pedal() // ez hibás, mert a változót Vehicle típus szerint ismerjük, azon nincs pedal()
    val vehicle: Vehicle = Vehicle()
    println(bike.getName())
    println(secretlyABike.getName())
    println(vehicle.getName())

    // A secretlyABike Vehicle típusú. Nem hívhatunk rajta Bicycle-metódusokat, viszont adhatunk neki
    // értékül Car-t (mert az is egy Vehicle). Ez néha hasznos (ebben az egyszerű példában nyilván nem,
    // de pl. a nevezési rendszer példában célszerű a Person lista használata, mert így egyszerre lehet
    // tanár és diák objektumokkal dolgozni.)
    secretlyABike = Car()
    println(secretlyABike.getName())
}
