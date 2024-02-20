package br.com.rafaseron.aluvery.ui.tests

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rafaseron.aluvery.R

@Preview(showBackground = true)
@Composable
fun DesafioDeDesign() {
    Row {
        Box(modifier = Modifier
            .background(color = Color.Blue)
            .width(30.dp)
            .height(70.dp))
        Column(modifier = Modifier.width(100.dp)) {
            Text(text = "Texto 1",
                modifier = Modifier
                    .background(color = Color.Gray)
                    .width(100.dp))
            Text(text = "Texto 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DesafioDeItem() {
    val imageSize = 80.dp
    val purple = colorResource(id = R.color.purple_500)
    val listaColor = listOf<Color>(Color.Blue, purple)

    Surface(modifier = Modifier
        .width(300.dp)
        .height(160.dp)
        .padding(3.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 15.dp){

        Row {
            Box(modifier = Modifier
                .fillMaxHeight(1f)
                .width(imageSize)
                .background(brush = Brush.verticalGradient(listaColor)))

            Image(modifier = Modifier
                .offset(x = -imageSize / 2, y = 40.dp)
                .height(imageSize)
                .width(imageSize)
                .clip(CircleShape)
                .border(2.dp, Color.Blue, CircleShape),
                painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Imagem do produto")

            Column(modifier = Modifier.offset(y = 20.dp, x = -30.dp)) {
                Text(text = LoremIpsum().values.first(),
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.offset(x = 7.dp))
            }

        }

    }
}