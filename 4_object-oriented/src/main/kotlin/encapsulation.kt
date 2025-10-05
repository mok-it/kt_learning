class Person2(
    val name: String,
    var age: Int
) {
    fun birthday() {
        age += 1
    }
}

fun main() {
    val p = Person2("József", 25) // példányosítás
    println(p.age)
    p.birthday()
    println(p.age) // ahogy vártuk, az életkor megnőtt
    p.age = 10 // ez baj, később még lesz róla szó (röviden: az age legyen private)
    println(p.age)
}
