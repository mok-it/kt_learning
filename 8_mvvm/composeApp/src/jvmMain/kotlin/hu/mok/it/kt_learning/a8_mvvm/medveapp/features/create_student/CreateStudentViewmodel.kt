package hu.mok.it.kt_learning.a8_mvvm.medveapp.features.create_student

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import hu.mok.it.kt_learning.a8_mvvm.medveapp.data.AllKnowingDatabase
import medveapp.Student
import medveapp.TShirtSize
import java.time.LocalDate
import kotlin.random.Random

class CreateStudentViewmodel : ViewModel() {

    val name = mutableStateOf("")

    fun onEvent(event: CreateStudentEvent) {

        when (event) {
            is CreateStudentEvent.NameChanged -> {
                name.value = event.newName
            }

            is CreateStudentEvent.CreateStudent -> {
                val student = Student(
                    name = name.value,
                    tShirtSize = TShirtSize.entries.toList()[Random.nextInt(TShirtSize.entries.size)],
                    birthDate = LocalDate.now()
                )
                AllKnowingDatabase.addStudent(student)
                name.value = ""
            }
        }
    }

}

sealed class CreateStudentEvent {
    data class NameChanged(val newName: String) : CreateStudentEvent()
    data object CreateStudent : CreateStudentEvent()
}