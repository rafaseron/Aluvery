package br.com.rafaseron.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rafaseron.aluvery.ui.components.ProductSection

@Composable
fun HomeScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
        .fillMaxSize(1f)
        .verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier)
        ProductSection("Promoções", br.com.rafaseron.aluvery.ui.components.sampleProductList)
        ProductSection("Salgadas", br.com.rafaseron.aluvery.ui.components.sampleProductList)
        ProductSection("Doces", br.com.rafaseron.aluvery.ui.components.sampleProductList)
        Spacer(modifier = Modifier)
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}