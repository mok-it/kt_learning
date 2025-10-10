package gorlaci.a6_compose.medveapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import medveapp.Camp

@Composable
fun RunCampCard(
    camp: Camp,
) {
    Card {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row {
                Text(
                    text = "${camp.year} - ${camp.location}",
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                )

                Button(
                    onClick = { camp.go() },
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Text("GO!!!")
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            LazyColumn {
                items(camp.accomodationReport()) { report ->
                    Text(text = report)

                }
            }
        }
    }
}