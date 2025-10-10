package gorlaci.a6_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun QuarterBlue() {
    Column(
        modifier = Modifier
            .fillMaxSize(0.5f)
            .background(color = Color.Blue)
    ) {
        Text(
            text = "This is written with White",
            color = Color.White
        )
    }
}

@Composable
fun ClickableColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                println("Clicked on column")
            }
    ) {
        Button(
            onClick = {
                println("Clicked on button")
            },
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text("A button")
        }
    }
}
