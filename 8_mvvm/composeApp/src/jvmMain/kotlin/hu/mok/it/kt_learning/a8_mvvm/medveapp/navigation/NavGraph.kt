package hu.mok.it.kt_learning.a8_mvvm.medveapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gorlaci.a6_compose.medveapp.ui.AddStudentsScreen
import gorlaci.a6_compose.medveapp.ui.CreateStudentScreen
import hu.mok.it.kt_learning.a8_mvvm.medveapp.features.Menu

@Composable
fun NavGraph(
    navHostController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Menu.route,
    ) {
        composable(Screen.Menu.route) {
            Menu(
                onCreateStudent = {
                    navHostController.navigate(Screen.CreateStudent.route)
                },
                onCreateTeacher = {
                    navHostController.navigate(Screen.CreateTeacher.route)
                },
                onCreateCamp = {
                    navHostController.navigate(Screen.CreateCamp.route)
                },
                onAddStudent = {
                    navHostController.navigate(Screen.AddStudent.route)
                },
                onAddTeacher = {
                    navHostController.navigate(Screen.AddTeacher.route)
                },
                onRunCamp = {
                    navHostController.navigate(Screen.RunCamp.route)
                }
            )
        }

        composable(Screen.CreateStudent.route) {
            CreateStudentScreen(
                onBack = { navHostController.popBackStack() },
            )
        }

        composable(Screen.AddStudent.route) {
            AddStudentsScreen(
                onBack = { navHostController.popBackStack() },
            )
        }
    }
}