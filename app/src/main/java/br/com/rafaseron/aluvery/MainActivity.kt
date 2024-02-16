package br.com.rafaseron.aluvery

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

@Composable
fun MyFirstComposable(){
    Text(text = "My First Composable")
    Text(text = "Texto maior bem maior ta ligado")
}

@Preview(name = "Preview Sem Argumentos / Ou Com Argumentos Diferentes",
    uiMode = Configuration.UI_MODE_NIGHT_YES /*,
    showSystemUi = true*/)
@Preview(name = "Preview Usando Argumentos",
    heightDp = 200,
    widthDp = 300,
    showBackground = true,
    backgroundColor = 0xFF008000)
@Composable
fun MyFirstComposablePreview(){
    AluveryTheme { //darkTheme so ta funcionando em API 31 - Android 12
        Surface {
            MyFirstComposable()
        }
    }

}