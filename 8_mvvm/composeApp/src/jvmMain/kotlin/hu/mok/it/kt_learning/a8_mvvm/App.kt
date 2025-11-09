package hu.mok.it.kt_learning.a8_mvvm

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import hu.mok.it.kt_learning.a8_mvvm.medveapp.navigation.NavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun App() {
    MaterialTheme {
        NavGraph()
    }
}