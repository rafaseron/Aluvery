package br.com.rafaseron.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rafaseron.aluvery.ui.components.ProductItemFinal
import br.com.rafaseron.aluvery.R
import br.com.rafaseron.aluvery.model.Product
import br.com.rafaseron.aluvery.ui.theme.AluveryTheme

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
            ProductItemFinal(
                Product("Hamburguer",
                "15.49",
                "Dois hamburgures, alface, queijo, molho especial, cebola, picles, num pao com gergelim",
                R.drawable.burger, "", true)
            )

            ProductItemFinal(
                Product("Fritas",
                "7,99",
                "",
                R.drawable.fries,
                "Fritas", false)
            )

            ProductItemFinal(
                Product("Pizza",
                "29,90",
                "", R.drawable.pizza,
                "", false)
            )



            //Spacer(modifier = Modifier) //esse spacer adiciona um espaco quando a lista terminar
        }
    }

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