package br.com.rafaseron.aluvery.ui.tests

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import br.com.rafaseron.aluvery.ui.components.ProductItem
import br.com.rafaseron.aluvery.R
import br.com.rafaseron.aluvery.ui.theme.AluveryTheme
import java.nio.file.WatchEvent
import kotlin.math.round

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

@Preview(showBackground = true)
@Composable
fun DesafioSecaoDeProdutos() {
    Column(modifier = Modifier.padding(
        top = 16.dp
    )) {

        Text(text = "Promoções", modifier = Modifier.padding(start = 16.dp,
            bottom = 16.dp),
            fontSize = 16.sp, fontWeight = FontWeight(400)
        )

        Row(modifier = Modifier
            .horizontalScroll(state = rememberScrollState())
            .verticalScroll(state = rememberScrollState())
            .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Spacer(modifier = Modifier)

            ProductItemWithDescription()
            ChallengeItemComDescricao(true, descricao = "isso aqui e um texto grandao aoao oaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoaoao")
            ChallengeItemComDescricao(false, descricao = "")
            ProductItem()
            ProductItemWithDescription()
            ProductItem()
            Spacer(modifier = Modifier)

        }

    }
    
}

@Preview
@Composable
fun ProductItemWithDescription() {
    Surface(shape = RoundedCornerShape(5),
        shadowElevation = 8.dp) {
        Column(
            verticalArrangement = Arrangement.spacedBy(-2.dp),
            modifier = Modifier
                .height(250.dp)
                .width(200.dp)
                .verticalScroll(state = rememberScrollState())) {
            ProductItem()
            Box(modifier = Modifier.offset(y = -10.dp)){
                TextDescription()
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun TextDescription() {
    val imageSize = 100.dp
    Surface(shape = RoundedCornerShape(10)) {
        AluveryTheme {
            Box(modifier = Modifier
                .heightIn(min = 250.dp, max = 300.dp)
                .width(imageSize * 2)){

                Text(text = LoremIpsum(500).values.first(),
                    Modifier
                        .background(color = Color.Magenta)
                        .padding(all = 10.dp))/*,
                    overflow = TextOverflow.Ellipsis)*/

            }
        }
    }
    
}

@Composable
fun ChallengeItemComDescricao(description: Boolean, descricao: String) {
    val purple = colorResource(id = R.color.purple_500)
    val listColors = listOf<Color>(purple, Color.Cyan)
    val imageSize = 100.dp //variavel para vincular e deixar padronizado os tamanhos dos composables

    Surface(shadowElevation = 8.dp, shape = RoundedCornerShape(10.dp)) {

        Column(modifier = Modifier
            .height(250.dp)
            .width(imageSize * 2)
            .verticalScroll(state = rememberScrollState())) {

            Box(modifier = Modifier
                .height(imageSize)
                .fillMaxWidth()
                .background(brush = Brush.horizontalGradient(colors = listColors))){

                Box(modifier = Modifier.padding(horizontal = 50.dp)){
                    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Imagem do Produto",
                        modifier = Modifier
                            .width(imageSize)
                            .height(imageSize)
                            /*.size(100.dp) da pra ser assim tbm o tamanho da imagem*/
                            .offset(y = imageSize / 2)
                            .clip(shape = CircleShape))
                }

            }

            Spacer(modifier = Modifier.height(imageSize/2))

            Column() {

                Text(text = LoremIpsum(50).values.first(), fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 16.dp,
                        vertical = 8.dp))
                Text(text = "R$ 14,99", fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(horizontal = 16.dp,
                        vertical = 8.dp))
            }

            if (description == true){
                Text(text = descricao,
                    modifier = Modifier
                        .offset(y = -8.dp)
                        .background(color = Color.Blue)
                        .padding(start = 16.dp, end = 16.dp,
                            top = 16.dp, bottom = 16.dp))
            }else{
            }

        }

    }

}