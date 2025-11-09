package gorlaci.a6_compose.medveapp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.mok.it.kt_learning.a8_mvvm.medveapp.features.create_student.CreateStudentEvent
import hu.mok.it.kt_learning.a8_mvvm.medveapp.features.create_student.CreateStudentViewmodel

@Composable
fun CreateStudentScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {

    val viewModel = viewModel { CreateStudentViewmodel() }

    val name by viewModel.name

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Create Student") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                }
            )
        }
    ) { paddingValues ->
        Row(
            modifier = Modifier.padding(paddingValues)
        ) {
            TextField(
                value = name,
                onValueChange = { newName ->
                    viewModel.onEvent(CreateStudentEvent.NameChanged(newName))
                },
                label = { Text("Student Name") }
            )

            Button(
                onClick = {
                    viewModel.onEvent(CreateStudentEvent.CreateStudent)
                }
            ) {
                Text("Create")
            }
        }
    }
}