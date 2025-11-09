package hu.mok.it.kt_learning.a8_mvvm.medveapp.data

import medveapp.Camp
import medveapp.Student
import medveapp.TShirtSize
import medveapp.Teacher
import java.time.LocalDate

object AllKnowingDatabase {

    private val students = mutableListOf<Student>()

    private val teachers = mutableListOf<Teacher>()

    private val camps = mutableListOf<Camp>(
        Camp(location = "Sástó", year = 2023, leader = Teacher("Pankó", TShirtSize.S, LocalDate.now())),
    )

    fun getStudents() = students.toList()

    fun getStudentById(id: Int) = students[id]

    fun getTeachers() = teachers.toList()

    fun getTeacherById(id: Int) = teachers[id]

    fun getCamps() = camps.toList()

    fun getCampById(id: Int) = camps[id]

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun addTeacher(teacher: Teacher) {
        teachers.add(teacher)
    }

    fun addCamp(camp: Camp) {
        camps.add(camp)
    }

}