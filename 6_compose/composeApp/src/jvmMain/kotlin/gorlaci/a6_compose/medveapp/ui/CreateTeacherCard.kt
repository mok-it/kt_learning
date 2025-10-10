package gorlaci.a6_compose.medveapp.ui


import androidx.compose.foundation.layout.Row
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import medveapp.TShirtSize
import medveapp.Teacher
import java.time.LocalDate
import kotlin.random.Random

@Composable
fun CreateTeacherCard(
    onCreateClick: (Teacher) -> Unit,
) {
    val name = remember { mutableStateOf("") }
    val favoriteTheamtic = remember { mutableStateOf("") }

    Card {
        Row {
            TextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Teacher Name") }
            )

            TextField(
                value = favoriteTheamtic.value,
                onValueChange = { favoriteTheamtic.value = it },
                label = { Text("Favorite Theamtic") }
            )

            Button(
                onClick = {
                    val teacher = Teacher(
                        name = name.value,
                        tShirtSize = TShirtSize.entries.toList()[Random.nextInt(TShirtSize.entries.size)],
                        birthDate = LocalDate.now(),
                        favoriteThematic = favoriteTheamtic.value,
                    )
                    onCreateClick(teacher)
                    name.value = ""
                    favoriteTheamtic.value = ""
                }
            ) {
                Text("Create")
            }
        }
    }
}