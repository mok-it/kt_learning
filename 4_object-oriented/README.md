# Objektumorientált programozás

Az objektumorientáltság egy _programozási paradigma._ Szabályokat, útmutatást ad arra vonatkozóan, hogy hogyan
szervezzük
logikusan, érthetően a kódunkat.

## Szemlélet

Az objektumorientált kód (vagy jobb esetben bármilyen kód) írásakor a célunk nem csak az, hogy a kész program helyesen
működjön. Fontos szempont, hogy a kód "szép" legyen. Legyen minél könnyebb egy-egy részt gyorsan megérteni, illetve
legyen karbantartható, utólag további funkciókkal bővíthető.

Alapvetően nem bízunk meg saját magunkban, sem egymásban. A kód egyes részei pont azért felelnek, hogy "visszafogjanak"
minket, pl. ne engedjék, hogy egy tetszőleges változóérték valahol "csak úgy" átíródjon, hiszen nagy kódbázis esetén
ennek igen kellemetlen, nehezen belátható következményei lehetnek.

## Jellemzők

Az objektumorientált kódnak fontos jellemzői vannak, ami miatt jobban szeretjünk a korábban látott megközelítésnél.

### Egységbe zárás (enkapszuláció)

Az egységbe zárás lényege, hogy a kód egymással erősen összefüggő, közeli kapcsolatban álló részeit egy logikai egységbe
rendezzük. Bizonyos adatok, és a rajtuk elvégezhető műveletek kerülnek jellemzően egy egységbe, melyet osztálynak
hívunk. Az osztályon (jellemzően benne tárolt adatokon) elvégezhető műveleteket metódusoknak hívunk. Az ily módon leírt
osztályok innentől típusokként működnek. Például definiálhatjuk a `Person` osztályt, majd étrehozhatunk egy változót,
melynek típusa Person. Ezt a folyamatot példányosításnak, a létrejövő példányt pedig objektumnak nevezzük.

```kotlin
class Person2(
    val name: String,
    var age: Int
) {
    fun birthday() {
        age += 1
    }
}

// -----
val p = Person2("József", 25) // példányosítás
p.birthday()
p.age = 10 // ez baj, később még lesz róla szó (röviden: az age legyen private)

```

### Polimorfizmus (többalakúság)

Ahogy alább közelebbről is látni fogjuk, az osztályok közt "részhalmaz" kapcsolat is kifejezhető, pl. minden bicikli
jármű. Ebben a kapcsolatban a biciklit alosztálynak, vagy leszármazottnak, a járművet pedig ősosztálynak nevezzük. A
leszármazottak felüldefiniálhatják az ős által leírt működést. Egy osztályból csak akkor lehet leszármazni, ha az `open`
kulcsszóval van definiálva.

```kotlin
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
        println("Ez fárasztó...")
    }
}

class Car : Vehicle() {
    override fun getName(): String {
        return "Autó"
    }
}
// -----
val bike: Bicycle = Bicycle()
bike.pedal()
var secretlyABike: Vehicle = Bicycle()
secretlyABike.pedal() // ez hibás, mert a változót Vehicle típus szerint ismerjük
val vehicle: Vehicle = Vehicle()
println(bike.getName())
println(secretlyABike.getName())
println(vehicle.getName())

secretlyABike = Car() // valid, mert Vehicle típusú a változó
println(secretlyABike.getName())
```

Így minden bicikli egyben jármű is. Ahogy láthatjuk, `Vehicle` típusú változónak is adhatunk értékül `Bicycle`
objektumot. A polimorfizmus célja, hogy bizonyos különbségeket figyelmen kívül hagyhatunk. Például a fentihez hasonlóan
tárolhatunk egy `Vehicle` típusú változót, amelyről nem tudjuk, hogy a pontos típusa `Vehicle`, `Bicycle`, vagy `Car`.
Ettől függetlenül elvégezhetünk vele bármilyen műveletet, amit egy `Vehicle`-ön lehet. Később látni fogjuk, hogy nem
feltétlenül célszerű a lehető legáltalánosabb típus szerint ismerni egy objektumot.

## További elemek

### Property (tagváltozó)

Egy osztálynak lehethek tagváltozói. Ezek olyan értékek, melyek egy-egy objektumra vonatkoznak, és az objektumon belül
elérhetők (pl. metódusokon belül).

```kotlin
class Car {
    val wheels = 4

    fun printWheels() {
        println(wheels)
    }
}
```

### Visibility (láthatóság)

Egy osztály bizonyos elemeinek korlátozhatjuk a láthatóságát, vagyis azt, hogy az adott elem kívülről elérhető-e.
Ez a `public`, `protected` vagy `private` kulcsszóval lehetséges. A publikus tulajdonságok és metódusok kívülről is
elérhetők, a privátak csak az osztály törzséből. A `protected` elemek csak az adott osztályból, és leszármazottjaiból
elérhetők (ez nem gyakran használjuk).

```kotlin
class Person3(
    public var name: String, // a default láthatóság public, ezt nem muszáj külön kiírni
    public var age: Int,
) {
    private var tajNumber: String = random() // nem létező függvény, csak demonstrációs célból
}
// -----
val person = Person3("József", 25)
println(person.name)
person.name = "Dezső"
println(person.age)
person.age = 28
println(person.tajNumber) // ilyet nem lehet csinálni, mert az adott tagváltozó privát
person.tajNumber = 123456789 // hasonlóan ilyet sem
```

### Konstruktor

A konstruktorok speciális függvények, melyek létrehoznak egy objektumot a megfelelő osztályból. Erre tulajdonképpen már
láttunk is példát:

```kotlin
class Person(           // Konstruktor: Person(n: String, age: Int)
    n: String,
    a: Int
) {
    val name = n
    val age = a
    // ...
}
//----------
val p = Person("József, 25") // példányosítás
```

Az osztály neve utáni zárójelbe a konstruktor paraméterei kerülnek. Egy objektum létrehozásakor ezt a `Person()`
függvényt kell meghívnunk, átadva a megfelelő értékeket (jelen esetben egy Sting és egy Int).

Ha az átadott elemekből tagváltozót szeretnénk létrehozni, akkor használhatunk egy rövidítést: a `val` vagy `var`
kulcsszót írhatjuk egyből a konstruktor paraméterei elé. Egy osztálynak több konstruktora is lehet, de ezeknek meg kell
hívniuk az elsődleges konstruktort.

```kotlin
class Person(           // Konstruktor: Person(name: String, age: Int)
    val name: String,
    val age: Int
) {
    constructor(name: String) : this(name, 0) { // másodlagos konstruktor, ami meghívja az elsődelegest
        println("$name megszületett!")
    }
}
```

### Interfész

Az interface-ek is a polimorfizmus témaköréhez tartoznak. Ezek tulajdonképpen implementáció nélküli ősosztályok.
Ezekben deklarálhatunk különböző metődusokat: megadhatjuk a nevüket, paraméterüket, és visszatérési érteküket, azonban
a metódusok működését itt nem kell leírnunk. Egy osztályról később leírhatjuk, hogy az adott interface-t implementálja,
ekkor az osztályban definiálnunk kell az összes metődust, ami az interface-ben deklarálva volt. (Nem véletlen, hogy a
példa ugyanaz, mint leszármazás esetén. Ezek nagyon hasonló koncepciók. Az interface több szabadságot enged (nem kell
változókat és konstruktort örökölni, csak adott metódusokat kell implementálni), ezért sokszor jobban szeretjük, de a
kettő szinte ugyanaz.)

```kotlin
interface Vehicle { // open class, ebből le lehet származni.
    fun getName(): String { //open függvényt lehet csak felülírni leszármazottban
        return "Jármű"
    }
}

class Bicycle : Vehicle {
    override fun getName(): String { //override kulcsszó: ősben definiált metódus felülírása
        return "Bicikli"
    }

    fun pedal() {
        println("Ez fárasztó...")
    }
}

class Car : Vehicle {
    override fun getName(): String {
        return "Autó"
    }
}
```

### Enum

Az enumok segítségével olyan típusokat lehet definiálni, melyeknek előre megadott, konkrét elemei vannak. Ezt gyakran
használjuk együtt a korábban látott `when` struktúrával, ezzel külön-külön kezelhetjük az összes lehetséges elemet.

```kotlin
enum class TrafficLampColor {
    RED,
    YELLOW,
    GREEN,
    RED_YELLOW,
    YELLOW_BLINK;

    fun next(): TrafficLampColor {
        return when (this) {
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
        if (color == YELLOW_BLINK) {
            color = RED
        }
    }

    fun turnOff() {
        color = YELLOW_BLINK
    }
}
```

### Data class

A data class egyfajta osztály, ami néhány extra kényelmi funkcióval bír. Alapból definiálva van rajta néhány hasznos
metódus (pl. `copy()`). Ezean kívül az egyenlőségvizsgálat is máshogy működik rajtuk. Ha két `Email` minden mezője
megegyezik, akkor a két email ugyanaz. Ez ellentétben van pl. egy `Person` osztállyal, ugyanis lehet, hogy két ember
minden tárolt adata (név, születési dátum, stb.) megegyezik, mégis különböző személyekről van szó. Leggyakrabban akkor
szoktunk data class használni, amikor az adott osztályt csak adattárolásra akarjuk
használni, és nincsenek bonyolult, összetett metódusai.

```kotlin
data class Email(
    val sender: String,
    val recipient: String,
    val title: String,
    val message: String,
    val sendDate: LocalDate
)
```

### Object

Az `Object` egy előre definiált típus, minden osztály ősosztálya. Ebből az öröklődést nem kell külön leírni, mint ahogy
azt korábban láttuk, automatikusan minden elem típusa `Object`.

```kotlin
var person: Object = Person("József", 25)
person.birthday() // Hiba: Object típuson nincs ilyen metódus
person = Vehicle() // Teljesen korrekt. A változó Object típusú, bármilyen objektum kerülhet bele
```

A fenti példához hasonló persze nem csak az object típussal állhat elő. Ha mondjuk a `Bicycle`-ben vannak további
metódusok, amik az általánosabb `Vehicle`-ben nem, (pl. lehet tekerni) akkor ez a művelet csak úgy végezhető el a
biciklin, ha `Bicycle` típuson keresztül ismerjük.

### Collection, List, ...

Egy klasszikus, visszatérő, és igen alapvető feladat, hogy egy gyűjteményben tárolni szeretnénk több (nem is tudjuk
mennyi) különböző objektumot. Erre léteznek beépített megoldások, ezekre nézünk most rá röviden. (A felsorolt
tulajdonságoknál és műveleteknél sokkal több mindent tartalmaznak ezek, csak a leggyakrabban használtakat említem meg.)

#### Collection

A `Collection` egy igen általános interface, ez olyan típusokat ír le, amik objektumok gyűjteményét tudják tárolni.
Olyan elemeket definiál, mint pl. `size: Int` (hány eleme van), `contains(T t): Bool` (benne van-e egy adott
elem), `isEmpty(): Bool` (üres-e), és különböző transzformációkat (`map`, `filter`, `fold`, stb, ezekről másik
alkalommal lesz szó).

#### MutableCollection

A `MutableCollection` annyival tud többet, hogy ehhez lehet elemeket hozzáadni, és kivenni belőle.
(Az alap `Collection`-t létrehozáskor lehet feltölteni elemekkel, és azok utána nem módosulnak.)

Ezen a következő további műveletek léteznek: `add(T t)` (elem hozzáadása) `remove(T t)` (elem törlése),
`addAll(Collection c)`, `removeAll(Collection c)` (másik kollekció összes elemének hozzáadása/törlése).

#### (Mutable)Set

A halmazban minden elem legfeljebb egyszer szerepelhet, illetve az elemei rendezetlenek. (Ha egy elem többször kerülne
bele, a halmaz garantálja, hogy az igazából csak egyszer fog szerepelni, a többi hozzáadást figyelmen kívül hagyja.)

#### (Mutable)List

A Lista egy egyszerű kollekció, melyben az elemek egy adott sorrendben szerepelnek, így minden elemnek van egy indexe.
Így index alapján elérhetők az elemei:

```kotlin
val list = listOf("a", "b", "c")

// elem keresése index szerint
println(list[0]) // "a"
println(list[1]) // "b"
// adott elem indexének megkeresése
println(list.indexOf("c")) // 2
```

#### (Mutable)Map

A `Map` egy kicsivel összetettebb, itt az elemek (elsősorban) nem index alapján, hanem valamilyen kulcs alapján kerülnek
tárolásra.

```kotlin
val patients = mapOf(
    "111222333" to Person("József", 25),
    "123456789" to Person("Béla", 37)
)
println(patients["111222333"]?.name ?: "Nincs ilyen tajszámú páciens")
```

### Package

Ez nem feltétlenül kötődik az objektumorientált paradigmához, de gyakran előfordul, (pl. Listák esetén) hogy egy adott
kotlin fájlban szeretnénk hivatkozni másik fájlban leírt típusokra. Ezek lehetnek általunk írt kódrészletek, de akár
egyéb forrásokból származók is. A fájlok első sorába kerül egy `package` kulcsszó, majd utána a package neve, amiben a
fájl található (ez jellemzően megegyezik a mappastruktúrával). Ahhoz, hogy erre más fájlból hivatkozhassunk, az `import`
utasítást használhatjuk, ami után megadjuk a package nevet. Az IntelliJ (és a legtöbb valamirevaló
fejlesztőkörnyezet) ebben segítséget nyújt nekünk, így ezeket jellemzően nem kell kézzel leírnunk. Azért nem árt tudni,
hogy ezek a fájl tetején találhatók.