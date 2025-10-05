enum class TrafficLampColor {
    RED,
    YELLOW,
    GREEN,
    RED_YELLOW,
    YELLOW_BLINK;

    fun next(): TrafficLampColor {
        return when (this) { // this: az aktuális szín
            RED -> RED_YELLOW
            RED_YELLOW -> GREEN
            GREEN -> YELLOW
            YELLOW -> RED
            YELLOW_BLINK -> YELLOW_BLINK
        }
    }
}

class TrafficLamp(var color: TrafficLampColor) {
    fun switch() {
        color = color.next()
    }

    fun turnOn() {
        if (color == TrafficLampColor.YELLOW_BLINK) {
            color = TrafficLampColor.RED
        }
    }

    fun turnOff() {
        color = TrafficLampColor.YELLOW_BLINK
    }
}

fun main() {
    val trafficLamp = TrafficLamp(TrafficLampColor.RED)
    println(trafficLamp.color)
    trafficLamp.switch()
    println(trafficLamp.color)
    trafficLamp.switch()
    println(trafficLamp.color)
    trafficLamp.switch()
    println(trafficLamp.color)

    trafficLamp.turnOff()
    println(trafficLamp.color)

    trafficLamp.switch()
    println(trafficLamp.color)

    trafficLamp.turnOn()
    println(trafficLamp.color)
}

