package gorlaci.a6_compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun SimpleCounter() {
    val count = remember { mutableStateOf(0) }

    Button(onClick = { count.value++ }) {
        Text("Clicked ${count.value} times")
    }
}

@Composable
fun SimplePicker() {

    val element = remember { mutableStateOf(DisplayElements.TEXT) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize(),
    ) {

        when (element.value) {
            DisplayElements.TEXT -> JustAText()
            DisplayElements.BUTTON -> JustAButton()
            DisplayElements.TEXTFIELD -> JustATextField()
            DisplayElements.DATEPICKER -> JustADatePicker()
            DisplayElements.IMAGE -> JustAnImage()
            DisplayElements.COUNTER -> SimpleCounter()
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Button(
                onClick = { element.value = DisplayElements.TEXT }
            ) {
                Text("Text")
            }
            Button(
                onClick = { element.value = DisplayElements.BUTTON }
            ) {
                Text("Button")
            }
            Button(onClick = { element.value = DisplayElements.TEXTFIELD }) {
                Text("TextField")
            }
            Button(onClick = { element.value = DisplayElements.DATEPICKER }) {
                Text("DatePicker")
            }
            Button(onClick = { element.value = DisplayElements.IMAGE }) {
                Text("Image")
            }
            Button(onClick = { element.value = DisplayElements.COUNTER }) {
                Text("Counter")
            }
        }
    }
}


enum class DisplayElements {
    TEXT,
    BUTTON,
    TEXTFIELD,
    DATEPICKER,
    IMAGE,
    COUNTER
}