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
import medveapp.Teacher

@Composable
fun AddTeachersCard(
    camps: List<Camp>,
    teachers: List<Teacher>,
    onAddClick: (Camp, Teacher, String) -> Unit,
) {

    val selectedCamp = remember { mutableStateOf(camps[0]) }
    val selectedTeacher = remember { mutableStateOf(teachers[0]) }
    val thematic = remember { mutableStateOf("") }

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

                    val expandedTeacher = remember { mutableStateOf(false) }

                    Row {
                        Text(text = selectedTeacher.value.name)
                        IconButton(onClick = { expandedTeacher.value = true }) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Select Teacher")
                        }
                    }

                    DropdownMenu(
                        expanded = expandedTeacher.value,
                        onDismissRequest = { expandedTeacher.value = false }
                    ) {
                        teachers.forEach { teacher ->
                            DropdownMenuItem(
                                text = { Text(teacher.name) },
                                onClick = {
                                    selectedTeacher.value = teacher
                                    expandedTeacher.value = false
                                }
                            )
                        }
                    }
                }


                TextField(
                    value = thematic.value,
                    onValueChange = { thematic.value = it },
                    label = { Text("Thematic") }
                )
            }

            Button(
                onClick = {
                    onAddClick(
                        selectedCamp.value,
                        selectedTeacher.value,
                        thematic.value.ifBlank { selectedTeacher.value.favoriteThematic }
                    )
                }
            ) {
                Text("Add Teacher to Camp")
            }
        }
    }
}