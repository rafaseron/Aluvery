package br.com.rafaseron.aluvery

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.rafaseron.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    MyFirstComposable()
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ColumnPreview() {
    Column {
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

@Preview (showBackground = true)
@Composable
fun CustomLayoutPreview() {
    Column {
        Text(text = "Rafael Seron")
        Text(text = "Android Developer")
        Row {
            Text(text = "RS")
            Text(text = "✅")
        }
        Box {
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