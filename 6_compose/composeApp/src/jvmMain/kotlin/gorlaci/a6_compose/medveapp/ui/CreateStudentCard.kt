package gorlaci.a6_compose.medveapp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import medveapp.Student
import medveapp.TShirtSize
import java.time.LocalDate
import kotlin.random.Random

@Composable
fun CreateStudentCard(
    onCreateClick: (Student) -> Unit,
) {
    val name = remember { mutableStateOf("") }

    Card {
        Row {
            TextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Student Name") }
            )

            Button(
                onClick = {
                    val student = Student(
                        name = name.value,
                        tShirtSize = TShirtSize.entries.toList()[Random.nextInt(TShirtSize.entries.size)],
                        birthDate = LocalDate.now(),
                    )
                    onCreateClick(student)
                    name.value = ""
                }
            ) {
                Text("Create")
            }
        }
    }
}