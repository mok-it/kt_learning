package gorlaci.a6_compose.medveapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.mok.it.kt_learning.a8_mvvm.medveapp.features.add_student.AddStudentsEvent
import hu.mok.it.kt_learning.a8_mvvm.medveapp.features.add_student.AddStudentsViewmodel

@Composable
fun AddStudentsScreen(
    onBack: () -> Unit,
) {

    val viewModel = viewModel { AddStudentsViewmodel() }

    val students by viewModel.students
    val camps by viewModel.camps

    val selectedCamp by viewModel.selectedCamp
    val selectedStudent by viewModel.selectedStudent


    Column {
        Row {
            Box {

                val expandedCamp by viewModel.campDropdownExpanded

                Row {
                    Text(text = "${selectedCamp.year}-${selectedCamp.location}")
                    IconButton(
                        onClick = { viewModel.onEvent(AddStudentsEvent.ChangeCampDropdownExpanded(!expandedCamp)) }
                    ) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Select Camp")
                    }
                }

                DropdownMenu(
                    expanded = expandedCamp,
                    onDismissRequest = { viewModel.onEvent(AddStudentsEvent.ChangeCampDropdownExpanded(false)) }
                ) {
                    camps.forEach { camp ->
                        DropdownMenuItem(
                            text = { Text("${camp.year}-${camp.location}") },
                            onClick = {
                                viewModel.onEvent(
                                    AddStudentsEvent.ChangeSelectedCamp(camp)
                                )
                            }
                        )
                    }
                }
            }

            Box {

                val expandedStudent by viewModel.studentDropdownExpanded

                Row {
                    Text(text = selectedStudent.name)
                    IconButton(onClick = { viewModel.onEvent(AddStudentsEvent.ChangeStudentDropdownExpanded(!expandedStudent)) }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Select Student")
                    }
                }

                DropdownMenu(
                    expanded = expandedStudent,
                    onDismissRequest = { viewModel.onEvent(AddStudentsEvent.ChangeStudentDropdownExpanded(false)) }
                ) {
                    students.forEach { student ->
                        DropdownMenuItem(
                            text = { Text(student.name) },
                            onClick = {
                                viewModel.onEvent(
                                    AddStudentsEvent.ChangeSelectedStudent(student)
                                )
                            }
                        )
                    }
                }
            }
        }

        Button(
            onClick = { viewModel.onEvent(AddStudentsEvent.AddStudentToCamp) }
        ) {
            Text("Add Student to Camp")
        }
    }
}