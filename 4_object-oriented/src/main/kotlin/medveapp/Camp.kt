package medveapp

data class Camp(
    val location: String,
    val year: Int,
    val leader: Teacher,
    val indexInYear: Int?
) {
    val students: MutableSet<Student> = mutableSetOf()
    val teacherThematics: MutableMap<Teacher, String> = mutableMapOf()

    // custom property: lehet definiálni egy get() és egy set() függvényt, ezután sima property-ként
    // kezelni, de a háttérben ezek a függvények fognak hívódni
    private val people
        get() = students + teacherThematics.keys

    constructor(location: String, year: Int, leader: Teacher) : this(location, year, leader, null) {
        println("No index provided, assuming null.")
    }

    fun accomodationReport(): List<String> {
        val ids: MutableList<String> = mutableListOf()
        for (p in people) {
            ids.add(p.personalID)
        }
        return ids
    }

    fun applyStudent(student: Student) {
        students.add(student)
    }

    fun applyTeacher(teacher: Teacher, thematics: String) {
        teacherThematics[teacher] = thematics
    }

    fun go() {
        index += 1
        println("Ez a(z) $index. matektábor!")
        for (s in students) {
            s.buyTShirt(this)
            s.learnedThematics.addAll(teacherThematics.values)
        }
    }

    companion object {
        var index = 0
    }

}