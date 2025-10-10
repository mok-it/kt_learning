package gorlaci.a6_compose

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "a6_compose",
    ) {
        App()
    }
}