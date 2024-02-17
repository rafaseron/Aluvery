package br.com.rafaseron.aluvery

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rafaseron.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    //MyFirstComposable()
                    CustomLayoutPreview()
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ColumnPreview() {
    Column(
        Modifier
            .background(color = Color.Magenta)
            .padding(all = 8.dp)) {
        Text(text = "My First Composable")
        Text(text = "Texto maior bem maior ta ligado")
    }
}

@Preview (showBackground = true)
@Composable
fun RowPreview() {
    Row {
        Text(text = "My First Composable")
        Text(text = "Texto maior bem maior ta ligado")
    }
}

@Preview (showBackground = true)
@Composable
fun BowPreview() {
    Box {
        Text(text = "My First Composable")
        Text(text = "Texto maior bem maior ta ligado")
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun CustomLayoutPreview() {
    Column(
        Modifier
            .padding(all = 10.dp)
            .background(color = Color.Blue)
            //.height(400.dp)
            //.width(200.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .fillMaxSize()) {
        Text(text = "Rafael Seron")
        Text(text = "Android Developer")
        Row(
            Modifier
                .padding(10.dp)
                .background(color = Color.Red)
                .fillMaxWidth()) {
            Text(text = "RS")
            Text(text = "✅")
        }
        Box(
            Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth(fraction = 0.5f)){ /*dessa forma ele
            ocupa 50% da fracao de tela que ele tem "disponivel"*/
            Text(text = "✅")
            Text(text = "Texto 6")
        }
    }


}

@Composable
fun MyFirstComposable(){
    Text(text = "My First Composable")
    Text(text = "Texto maior bem maior ta ligado")
}

@Preview
@Composable
fun MyFirstComposablePreview(){
    AluveryTheme {
        Surface {
            MyFirstComposable()
        }
    }

}