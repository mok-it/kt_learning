# Funkcionális programozás

A funkcionális programozás (FP) az objektumorientáltsághoz hasonlóan egy _programozási paradimga_, vagyis egyfajta
szabályrendszer arra, hogy milyen kódot írjunk.

Az FP tulajdonképpen az objektumorientáltság "ellenforradalma". (A gyakorlatban persze mindkettőnek megvan a helye, sőt,
sokszor kombinálják a két szemléletet.) A sok különböző osztálynak mind van valamiféle belső
állapota, ami befolyásolja a működését. Ezeknek az együttes hatása sokszor nehezen követhető végig, előállhatnak
határesetek, amikre nem számítottunk.

## "Tiszta" függvények (Pure functions)

A funkcionális programozás visszatér a *matematikai értelemben vett* függvényekhez: egyértelmű hozzárendelések
inputokról valamilyen outputra. Nincs belső állapot, és a függvény nem "változtat" semmit, csak visszaadja az új értéket
a bemeneteknek megfelelően.

## Változtathatatlanság (Immutability)

Az FP során nem szeretünk váltakozó állpotot fenntartani. Minden "változó" legyen `val`, a listák elemei létrehozás után
ne változzanak (helyette hozzunk létre új listát) stb.

## függvény mint változóérték

Praktikus tud lenni, ha egy változóban tárolhatunk függvényt, illetve ha pl. egy függvény paramétere lehet egy másik
függvény.

### Típusjelölések:

- `() -> Unit` - egy függvény, aminek nincs paramétere, és visszatérési értéke sem
- `(String) -> Int` - egy függvény, aminek egy `String` paramétere van, és egy `Int` értéket ad vissza
- `(String, String, String) -> Int` - egy függvény, aminek három `String` paramétere van, és egy `Int` értéket ad vissza

Megjegyzés: Ha egy függvénynek nincs paramétere vagy visszatérési értéke, az általában nem "tiszta" függvény, hiszen
ha az lenne, (vagyik csak egy hozzárendelés lenne bemenet és kimenet közt,) akkor nem lenne valami hasznos.

### Lambdák

lambdának hívjuk azokat a névtelen függvényeket, amiket "csak úgy menet közben" hozunk létre, például amikor azt egy
függvény paramétereként szeretnénk megadni.

```kotlin
val myLambda: (String) -> Int = { x: String -> x.length }
```

Fent azt láthatjuk, hogy egy `myLambda` nevű változónak értékül adunk egy lambdát. A lambdát kapcsos zárójelek közé
írjuk. Ennek van egy `x: String` paramétere, és visszaadja ennek a szövegnek a hosszát. A Kotlin a már megszokott módon
kitalálja az egyenlőségjel után leírt kifejezés típusát, így ennek a változónév utáni megadása elhagyható.

```kotlin
val myLambda = { x: String -> x.length }
```

Megtehetjük ehelyett, hogy az `x` utáni `String` típusjelölést hagyjuk el, mindkettőt azonban itt nem lehet, mert akkor
nem maradna elég információ ahhoz, hogy a Kotlin kitalálja a típusokat.

```kotlin
val myLambda: (String) -> Int = { x -> x.length }
```

Egy paraméterrel rendelkező lambdák esetén további rövidítés, hogy a paraméternek nem kell nevet adni (fent `x`).
Ehelyett az automatikusan megadott `it` nevet használhatjuk.

```kotlin
val myLambda: (String) -> Int = { it.length }
```

Most pedig lássunk egy példát arra, hogy mire használható ez:

A `map` egy klasszikus, igen sok programozási nyelven létező művelet. Ez egy lista minden elemén végrehajt valamilyen
transzformációt, és visszaadja az új listát.

```kotlin
val list = listOf("a", "bc", "def")
val newList = list.map({ it.length }) //[1, 2, 3]
```

A map függvény paramétere egy függvény, ami megadja, hogy a lista egyes elemeit hogyan kell átalakítani. A fenti
példában a lambda egy stringhez hozzárendeli a hosszát. A map ennek megfelelően visszaad egy listát, melyben az eredeti
lista szavainak hossza szerepel.

Ha egy függvénynek adunk át lambdát, hasznos rövidítés, hogy a **paraméterlistában utólsóként szereplő lambdát**
írhatjuk a paramétereket jelző kerek zárójeleken kívül. Ha ez a lambda volt az egyetlen paraméter, a megüresedett kerek
zárójeleket elhagyhatjuk.

```kotlin
val list = listOf("a", "bc", "def")
val newList = list.map { it.length } //[1, 2, 3]
```
