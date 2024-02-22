package br.com.rafaseron.aluvery

import android.content.res.Configuration
import android.os.Bundle
import android.transition.CircularPropagation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import br.com.rafaseron.aluvery.model.Product
import br.com.rafaseron.aluvery.ui.tests.ChallengeItemComDescricao
import br.com.rafaseron.aluvery.ui.tests.DesafioDeItem
import br.com.rafaseron.aluvery.ui.tests.DesafioSecaoDeProdutos
import br.com.rafaseron.aluvery.ui.tests.ProductItemWithDescription
import br.com.rafaseron.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {

                }
            }
        }
    }
}

@Composable
fun App() {
    AluveryTheme {
        Surface {
            Spacer(modifier = Modifier)
            Column(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
                .fillMaxSize(1f)
                .verticalScroll(rememberScrollState())) {
                Spacer(modifier = Modifier.padding(top = 2.dp))
                ProductSection()
                ProductSection()
                ProductSection()
                Spacer(modifier = Modifier.padding(bottom = 100.dp))
            }
        }
    }

}

@Composable
fun ProductSection () {
    Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {

        Text(text = "Promoções",
            fontWeight = FontWeight(400),
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp))


        Row(modifier = Modifier
            .padding(
                end = 16.dp
            )
            .fillMaxWidth()
            .horizontalScroll(state = rememberScrollState() /*ScrollState(0)*/),
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Spacer(modifier = Modifier) //esse spacer adiciona um espaco antes da lista iniciar
            ProductItem()
            ProductItemFinal(Product("Hamburguer",
                "15.49",
                "Dois hamburgures, alface, queijo, molho especial, cebola, picles, num pao com gergelim",
                R.drawable.burger, "", true))

            ProductItemFinal(Product("Fritas",
                "7,99",
                "",
                R.drawable.fries,
                "Fritas", false))

            ProductItemFinal(Product("Pizza",
                "29,90",
                "", R.drawable.pizza,
                "", false))



            //Spacer(modifier = Modifier) //esse spacer adiciona um espaco quando a lista terminar
        }
    }
    
}

@Composable
fun ProductItem() {
    val purple = colorResource(id = R.color.purple_500)
    val listColors = listOf<Color>(purple, Color.Cyan)
    val imageSize = 100.dp //variavel para vincular e deixar padronizado os tamanhos dos composables

    Surface(shadowElevation = 8.dp, shape = RoundedCornerShape(10.dp)) {

        Column(modifier = Modifier
            .heightIn(min = 250.dp, max = 300.dp)
            .width(imageSize * 2)) {

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

}
@Composable
fun ProductItemFinal(produto: Product) {

    val hasDescription = produto.temDescricao
    val purple = colorResource(id = R.color.purple_500)
    val listColors = listOf<Color>(purple, Color.Cyan)
    val imageSize = 100.dp //variavel para vincular e deixar padronizado os tamanhos dos composables

    Surface(shadowElevation = 8.dp, shape = RoundedCornerShape(10.dp)) {

        Column(
            modifier = Modifier
                .height(250.dp)
                .width(imageSize * 2)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {

            Box(
                modifier = Modifier
                    .height(imageSize)
                    .fillMaxWidth()
                    .background(brush = Brush.horizontalGradient(colors = listColors))
            ) {

                Box(modifier = Modifier.padding(horizontal = 50.dp)) {
                    Image(
                        painter = painterResource(id = produto.imageId),
                        contentDescription = produto.contentDescription,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(imageSize)
                            .height(imageSize)
                            .offset(y = imageSize / 2)
                            .clip(shape = CircleShape)
                    )
                }

            }

            Spacer(modifier = Modifier.height(imageSize / 2))

            Column(
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            ) {

                Text(
                    text = produto.name, fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                )
                Text(
                    text = "R$ ${produto.price.toString()}", fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                )
            }

            if (hasDescription == true){
                Text(text = produto.discription,
                    modifier = Modifier
                        .offset(y = -8.dp)
                        .background(color = Color.Blue)
                        .padding(
                            start = 16.dp, end = 16.dp,
                            top = 16.dp, bottom = 16.dp
                        ))
            }else{
            }

        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
    
}

@Preview(showBackground = true, /*widthDp = 1000*/)
@Composable
private fun ProductSectionPreview() {
    Surface {
        AluveryTheme {
            ProductSection()
        }
    }
}

@Preview(showBackground = true, /*showSystemUi = true*/)
@Composable
private fun ProductItemPreview() {
    Surface {
        AluveryTheme {
            ProductItem()
        }
    }
    
}



