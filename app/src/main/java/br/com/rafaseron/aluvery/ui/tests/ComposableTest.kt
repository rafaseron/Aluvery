package br.com.rafaseron.aluvery.ui.tests

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rafaseron.aluvery.R
import br.com.rafaseron.aluvery.model.Product
import br.com.rafaseron.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Preview(showBackground = true)
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

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    Row {
        Text(text = "My First Composable")
        Text(text = "Texto maior bem maior ta ligado")
    }
}

@Preview(showBackground = true)
@Composable
fun BowPreview() {
    Box {
        Text(text = "My First Composable")
        Text(text = "Texto maior bem maior ta ligado")
    }
}

@Preview(showBackground = true, showSystemUi = true)
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

@Composable
fun ItemDescritivo(produto: Product) {

    val hasDescription = produto.temDescricao
    val purple = colorResource(id = R.color.purple_500)
    val listColors = listOf<Color>(purple, Color.Cyan)
    val imageSize = 100.dp //variavel para vincular e deixar padronizado os tamanhos dos composables

    Surface(shadowElevation = 8.dp, shape = RoundedCornerShape(10.dp)) {

        Column(
            modifier = Modifier
                .heightIn(min = 250.dp, max = 300.dp)
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
                    text = produto.price.toString(), fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                )
            }

            if (hasDescription == true){
                Text(text = produto.discription,
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
@Preview
@Composable
fun ItemComDescricaoPreview() {
    Surface(modifier = Modifier.height(250.dp).padding(16.dp), shape = RoundedCornerShape(10.dp),
        shadowElevation = 8.dp) {
        val objetoProduto = Product(
            nome = "Burguer",
            descricao = "Dois hamburgueres, alface, queijo, molho especial, cebola, picles num pao com gergelim",
            conteutoDescritivo = "descricao da imagem",
            imagemId = R.drawable.burger,
            preco = "15,49",
            hasDiscription = true
        )
        ItemDescritivo(objetoProduto)
    }
}
@Preview
@Composable
fun ItemSemDescricaoPreview() {
    Surface(modifier = Modifier.height(250.dp).padding(16.dp), shape = RoundedCornerShape(10.dp),
        shadowElevation = 8.dp) {
        val objetoProduto = Product(
            nome = "Burguer",
            descricao = "",
            conteutoDescritivo = "descricao da imagem",
            imagemId = R.drawable.burger,
            preco = "15,49",
            hasDiscription = false
        )
        ItemDescritivo(objetoProduto)
    }
}