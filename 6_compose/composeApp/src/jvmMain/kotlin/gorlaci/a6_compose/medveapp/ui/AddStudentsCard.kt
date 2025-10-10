package gorlaci.a6_compose.medveapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import medveapp.Camp
import medveapp.Student

@Composable
fun AddStudentsCard(
    camps: List<Camp>,
    students: List<Student>,
    onAddClick: (Camp, Student ) -> Unit,
) {

    val selectedCamp = remember { mutableStateOf(camps[0]) }
    val selectedStudent = remember { mutableStateOf(students[0]) }

    Card {

        Column {
            Row {
                Box {

                    val expandedCamp = remember { mutableStateOf(false) }

                    Row {
                        Text(text = "${selectedCamp.value.year}-${selectedCamp.value.location}")
                        IconButton(onClick = { expandedCamp.value = true }) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Select Camp")
                        }
                    }

                    DropdownMenu(
                        expanded = expandedCamp.value,
                        onDismissRequest = { expandedCamp.value = false }
                    ) {
                        camps.forEach { camp ->
                            DropdownMenuItem(
                                text = { Text("${camp.year}-${camp.location}") },
                                onClick = {
                                    selectedCamp.value = camp
                                    expandedCamp.value = false
                                }
                            )
                        }
                    }
                }

                Box {

                    val expandedStudent = remember { mutableStateOf(false) }

                    Row {
                        Text(text = selectedStudent.value.name)
                        IconButton(onClick = { expandedStudent.value = true }) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Select Student")
                        }
                    }

                    DropdownMenu(
                        expanded = expandedStudent.value,
                        onDismissRequest = { expandedStudent.value = false }
                    ) {
                        students.forEach { student ->
                            DropdownMenuItem(
                                text = { Text(student.name) },
                                onClick = {
                                    selectedStudent.value = student
                                    expandedStudent.value = false
                                }
                            )
                        }
                    }
                }
            }

            Button( onClick = { onAddClick(selectedCamp.value, selectedStudent.value) } ) {
                Text("Add Student to Camp")
            }
        }
    }
}