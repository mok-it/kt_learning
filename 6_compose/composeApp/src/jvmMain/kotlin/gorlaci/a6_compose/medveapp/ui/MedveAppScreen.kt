package gorlaci.a6_compose.medveapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import gorlaci.a6_compose.medveapp.ui.MedveAppState.*
import medveapp.Camp
import medveapp.Student
import medveapp.Teacher

@Composable
fun MedveAppScreen() {


    val teachers = remember { mutableStateOf(listOf<Teacher>()) }
    val students = remember { mutableStateOf(listOf<Student>()) }
    val camps = remember { mutableStateOf(listOf<Camp>()) }

    val appState = remember { mutableStateOf(CREATE_STUDENT) }

    Row(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(modifier = Modifier.fillMaxHeight().fillMaxWidth(0.8f)) {
            when (appState.value) {
                CREATE_STUDENT -> CreateStudentCard(
                    onCreateClick = { student ->
                        students.value += student
                    }
                )

                CREATE_TEACHER -> CreateTeacherCard(
                    onCreateClick = { teacher ->
                        teachers.value += teacher
                    }
                )

                CREATE_CAMP -> CreateCampCard(
                    teachers = teachers.value,
                    onCreateClick = { camp ->
                        camps.value += camp
                    }
                )

                ADD_STUDENT -> AddStudentsCard(
                    camps = camps.value,
                    students = students.value,
                    onAddClick = { camp, student ->
                        camp.applyStudent(student)
                    }
                )

                ADD_TEACHER -> AddTeachersCard(
                    camps = camps.value,
                    teachers = teachers.value,
                    onAddClick = { camp, teacher, thematic ->
                        camp.applyTeacher(teacher, thematic)
                    }
                )

                RUN_CAMP -> RunCampCard(
                    camp = camps.value[0],
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = { appState.value = CREATE_STUDENT }
            ) {
                Text("Create student")
            }
            Button(
                onClick = { appState.value = CREATE_TEACHER }
            ) {
                Text("Create teacher")
            }
            Button(
                onClick = { appState.value = CREATE_CAMP }
            ) {
                Text("Create camp")
            }
            Button(
                onClick = { appState.value = ADD_STUDENT }
            ) {
                Text("Add student to camp")
            }
            Button(
                onClick = { appState.value = ADD_TEACHER }
            ) {
                Text("Add teacher to camp")
            }
            Button(
                enabled = camps.value.isNotEmpty(),
                onClick = { appState.value = RUN_CAMP }
            ) {
                Text("Run camp")
            }
        }
    }
}


enum class MedveAppState {
    CREATE_STUDENT,
    CREATE_TEACHER,
    CREATE_CAMP,
    ADD_STUDENT,
    ADD_TEACHER,
    RUN_CAMP
}

