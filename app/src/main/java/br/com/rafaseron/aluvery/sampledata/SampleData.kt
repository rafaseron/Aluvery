package br.com.rafaseron.aluvery.sampledata

import br.com.rafaseron.aluvery.R
import br.com.rafaseron.aluvery.model.Product


val sampleProductList:List<Product> = listOf(

    Product(
        "Hamburguer",
        "15.49",
        "Dois hamburgures, alface, queijo, molho especial, cebola, picles, num pao com gergelim",
        R.drawable.burger, "", true
    ),

    Product(
        "Fritas",
        "7,99",
        "",
        R.drawable.fries,
        "Fritas", false
    ),

    Product(
        "Pizza",
        "29,90",
        "", R.drawable.pizza,
        "", false
    )
)