package gorlaci.a6_compose.medveapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import medveapp.Camp
import medveapp.Teacher

@Composable
fun CreateCampCard(
    teachers: List<Teacher>,
    onCreateClick: (Camp) -> Unit,
) {

    val location = remember { mutableStateOf("Sástó") }
    val year = remember { mutableStateOf(2025) }
    val leader = remember { mutableStateOf<Teacher?>(null) }

    Card {
        Column {
            TextField(
                value = location.value,
                onValueChange = { location.value = it },
                label = { Text("Camp Location") }
            )
            Row {
                IconButton(onClick = { year.value-- }) {
                    Icon(Icons.Default.Remove, contentDescription = "Decrease year")
                }
                TextField(
                    value = year.value.toString(),
                    onValueChange = { year.value = it.toIntOrNull() ?: year.value },
                    label = { Text("Year") }
                )
                IconButton(onClick = { year.value++ }) {
                    Icon(Icons.Default.Add, contentDescription = "Increase year")
                }
            }

            val expanded = remember { mutableStateOf(false) }
            Box {
                Row {
                    Text(text = leader.value?.name ?: "Select Leader")
                    IconButton(onClick = { expanded.value = true }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Select Leader")
                    }
                }
                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false }
                ) {
                    teachers.forEach { teacher ->
                        DropdownMenuItem(
                            text = { Text(teacher.name) },
                            onClick = {
                                leader.value = teacher
                                expanded.value = false
                            }
                        )
                    }
                }
            }

            Button(
                enabled = leader.value != null,
                onClick = {
                    val camp = Camp(
                        location = location.value,
                        year = year.value,
                        leader = leader.value!!
                    )
                    onCreateClick(camp)
                }
            ) {
                Text("Create Camp")
            }
        }

    }

}