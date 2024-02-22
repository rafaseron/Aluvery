package br.com.rafaseron.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.rafaseron.aluvery.ui.screens.HomeScreen
import br.com.rafaseron.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    AluveryTheme {
        Surface {
            HomeScreen()
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
}



