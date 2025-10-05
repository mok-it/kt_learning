interface Vehiclee { // open class, ebből le lehet származni.
    fun getName(): String { //open függvényt lehet csak felülírni leszármazottban
        return "Jármű"
    }
}

class Bicyclee : Vehiclee {
    override fun getName(): String { //override kulcsszó: ősben definiált metódus felülírása
        return "Bicikli"
    }

    fun pedal() {
        println("Ez fárasztó...")
    }
}

class Carr : Vehiclee {
    override fun getName(): String {
        return "Autó"
    }
}

fun main() {
    val bike: Bicyclee = Bicyclee()
    bike.pedal()
    var secretlyABike: Vehiclee = Bicyclee()
    //secretlyABike.pedal() // ez hibás, mert a változót Vehicle típus szerint ismerjük
    //val vehicle: Vehiclee = Vehiclee() // ez itt nem valid, mivel egy interface közvetlenül nem példányosítható
    println(bike.getName())
    println(secretlyABike.getName())

    secretlyABike = Carr() // valid, mert Vehicle típusú a változó
    println(secretlyABike.getName())
}
