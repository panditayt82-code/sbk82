package com.sublikami.inventario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen(
    products: List<Product>,
    onProductClick: (Product) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FB))
            .padding(16.dp)
    ) {
        Text("Inventario Sublikami", style = MaterialTheme.typography.h5)

        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Total productos", style = MaterialTheme.typography.body1)
                    Text("${products.size}", fontSize = 24.sp, color = Color.Blue)
                }
                Column {
                    Text("Unidades disponibles", style = MaterialTheme.typography.body1)
                    val totalUnits = products.sumOf { it.stock }
                    Text("$totalUnits", fontSize = 24.sp, color = Color.Green)
                }
            }
        }

        LazyColumn {
            items(products.size) { idx ->
                ProductCard(products[idx]) { onProductClick(products[idx]) }
            }
        }
    }
}