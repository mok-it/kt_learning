package hu.mok.it.kt_learning.a8_mvvm.medveapp.features.add_student

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import hu.mok.it.kt_learning.a8_mvvm.medveapp.data.AllKnowingDatabase
import medveapp.Camp
import medveapp.Student

class AddStudentsViewmodel : ViewModel() {

    private val _students = AllKnowingDatabase.getStudents()
    val students = mutableStateOf(_students)

    private val _camps = AllKnowingDatabase.getCamps()
    val camps = mutableStateOf(_camps)

    val selectedStudent = mutableStateOf(_students[0])

    val selectedCamp = mutableStateOf(_camps[0])

    val campDropdownExpanded = mutableStateOf(false)

    val studentDropdownExpanded = mutableStateOf(false)

    fun onEvent(event: AddStudentsEvent) {
        when (event) {
            is AddStudentsEvent.AddStudentToCamp -> {
                selectedCamp.value.applyStudent(selectedStudent.value)
            }

            is AddStudentsEvent.ChangeSelectedCamp -> {
                selectedCamp.value = event.camp
                campDropdownExpanded.value = false
            }

            is AddStudentsEvent.ChangeSelectedStudent -> {
                selectedStudent.value = event.student
                studentDropdownExpanded.value = false
            }

            is AddStudentsEvent.ChangeCampDropdownExpanded -> {
                campDropdownExpanded.value = event.expanded
            }

            is AddStudentsEvent.ChangeStudentDropdownExpanded -> {
                studentDropdownExpanded.value = event.expanded
            }
        }
    }
}

sealed class AddStudentsEvent {
    data object AddStudentToCamp : AddStudentsEvent()
    data class ChangeSelectedCamp(val camp: Camp) : AddStudentsEvent()
    data class ChangeSelectedStudent(val student: Student) : AddStudentsEvent()
    data class ChangeCampDropdownExpanded(val expanded: Boolean) : AddStudentsEvent()
    data class ChangeStudentDropdownExpanded(val expanded: Boolean) : AddStudentsEvent()
}