package hu.mok.it.kt_learning.a8_mvvm.medveapp.navigation

sealed class Screen(
    val route: String,
) {
    object Menu : Screen("menu")
    object AddStudent : Screen("add_student")
    object AddTeacher : Screen("add_teacher")
    object CreateStudent : Screen("create_student")
    object CreateTeacher : Screen("create_teacher")
    object CreateCamp : Screen("create_camp")
    object RunCamp : Screen("run_camp")
}