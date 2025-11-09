package gorlaci.a6_compose

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import hu.mok.it.kt_learning.a8_mvvm.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "a6_compose",
    ) {
        App()
    }
}