package gorlaci.a6_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddHome
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DefaultRow() {
    Row {
        JustAButton()
        JustAButton()
        JustAButton()
    }
}

@Composable
fun DefaultColumn() {
    Column {
        JustAButton()
        JustAButton()
        JustAButton()
    }
}

@Composable
fun ColumnWithManyButtons() {
    Column {
        repeat(50) {
            JustAButton()
        }
    }
}

@Composable
fun LazyColumnWithManyButtons() {
    LazyColumn {
        repeat(50) {
            item {
                JustAButton()
            }
        }
    }
}

@Composable
fun DifferentArrangements() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            JustAButton()
            JustAButton()
            JustAButton()
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            JustAButton()
            JustAButton()
            JustAButton()
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            JustAButton()
            JustAButton()
            JustAButton()
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            JustAButton()
            JustAButton()
            JustAButton()
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            JustAButton()
            JustAButton()
            JustAButton()
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            JustAButton()
            JustAButton()
            JustAButton()
        }
    }
}

@Composable
fun DifferentAlignments() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .background(Color.Red)
        ) {
            JustAButton()
            JustAButton()
            JustAButton()
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .background(Color.Green)
        ) {
            JustAButton()
            JustAButton()
            JustAButton()
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .background(Color.Blue)
        ) {
            JustAButton()
            JustAButton()
            JustAButton()
        }
    }
}

@Composable
fun DefaultBox() {
    Box {
        JustADatePicker()
        JustAButton()
    }
}

@Composable
fun BoxAlignments() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        JustAnImage()

        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text("Click me")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Text("Click me")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Text("Click me")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text("Click me")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text("Click me")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text("Click me")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text("Click me")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text("Click me")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text("Click me")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My App") },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Navigate backwards")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Image, null)

                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.AddHome, null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        Icon(Icons.Default.Add, null)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Home, null)
                    }
                    TextButton(onClick = {}) {
                        Text("List")
                    }
                }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hello Scaffold!")
            Text("Content goes here")
        }
    }
}