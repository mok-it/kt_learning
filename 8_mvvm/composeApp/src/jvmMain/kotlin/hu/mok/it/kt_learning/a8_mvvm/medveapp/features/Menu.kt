package hu.mok.it.kt_learning.a8_mvvm.medveapp.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Menu(
    onCreateStudent: () -> Unit,
    onCreateTeacher: () -> Unit,
    onCreateCamp: () -> Unit,
    onAddStudent: () -> Unit,
    onAddTeacher: () -> Unit,
    onRunCamp: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onCreateStudent,
        ) {
            Text("Create student")
        }
        Button(
            onClick = onCreateTeacher,
        ) {
            Text("Create teacher")
        }
        Button(
            onClick = onCreateCamp
        ) {
            Text("Create camp")
        }
        Button(
            onClick = onAddStudent
        ) {
            Text("Add student to camp")
        }
        Button(
            onClick = onAddTeacher
        ) {
            Text("Add teacher to camp")
        }
        Button(
            onClick = onRunCamp
        ) {
            Text("Run camp")
        }
    }
}