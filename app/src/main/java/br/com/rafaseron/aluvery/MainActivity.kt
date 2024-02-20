package br.com.rafaseron.aluvery

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rafaseron.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductItem()
                }
            }
        }
    }
}

@Preview(showBackground = true/*, showSystemUi = true*/)
@Composable
fun ProductItem() {
    val purple = colorResource(id = R.color.purple_500)
    val listColors = listOf<Color>(purple, Color.Cyan)
    Column(modifier = Modifier
        .height(250.dp)
        .width(200.dp)
        .clip(RoundedCornerShape(15.dp))
        .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp))) {
        Box(modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(brush = Brush.horizontalGradient(colors = listColors))){

            Box(modifier = Modifier.padding(horizontal = 50.dp)){
                Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Imagem do Produto",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        /*.size(100.dp) da pra ser assim tbm o tamanho da imagem*/
                        .offset(y = 50.dp)
                        .clip(shape = CircleShape))
            }

        }

        Spacer(modifier = Modifier.height(50.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp,
            vertical = 8.dp)) {

            Text(text = LoremIpsum(50).values.first(), fontSize = 18.sp,
                fontWeight = FontWeight(700),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier)
            Text(text = "R$ 14,99", fontSize = 14.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier)
        }


    }
}



