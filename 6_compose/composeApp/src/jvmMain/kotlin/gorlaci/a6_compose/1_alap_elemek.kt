package gorlaci.a6_compose

import a6_compose.composeapp.generated.resources.Res
import a6_compose.composeapp.generated.resources.compose_multiplatform
import androidx.compose.foundation.Image
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.painterResource

@Composable
fun JustAText() {
    Text("Just a text")
}

@Composable
fun JustAButton() {
    Button(
        onClick = { println("Clicked!!") }
    ) {
        Text("Just a button")
    }
}

@Composable
fun JustATextField() {
    var text = "Just a text field"
    TextField(
        value = text,
        onValueChange = { text = it }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JustADatePicker() {
    val state = rememberDatePickerState()
    DatePicker(
        state = state
    )
}

@Composable
fun JustAnImage() {
    Image(painterResource(Res.drawable.compose_multiplatform), null)
}
