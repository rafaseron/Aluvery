package br.com.rafaseron.aluvery.ui.tests

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun DesafioDeDesign() {
    Row {
        Box(modifier = Modifier.background(color = Color.Blue)
            .width(30.dp)
            .height(70.dp))
        Column(modifier = Modifier.width(100.dp)) {
            Text(text = "Texto 1",
                modifier = Modifier.background(color = Color.Gray)
                    .width(100.dp))
            Text(text = "Texto 2")
        }
    }
}