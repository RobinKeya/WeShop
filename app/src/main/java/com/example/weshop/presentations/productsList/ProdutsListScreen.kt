package com.example.weshop.presentations.productsList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.weshop.data.remote.Product

@Composable
fun ProductListScreen(
    productListScreenState: ProductListScreenState,
    onProductClick: (id: Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        LazyRow(contentPadding = PaddingValues(4.dp)){
            items(productListScreenState.categories){ category->
                CategoryItem(category)
            }
        }
        LazyColumn(contentPadding = PaddingValues(4.dp)){
            items(productListScreenState.products){product->
                ProductItem(product){id->
                    onProductClick(id)
                }
            }
        }
    }
}

@Composable
fun CategoryItem(category: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .padding(4.dp)
            .size(32.dp)
    ) {
        Text(text = category)
    }
}

@Composable
fun ProductItem(product: Product, onProductClick: (id: Int)->Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .clickable { onProductClick(product.id) }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(imageVector = Icons.Filled.ShoppingCart, contentDescription =null )
            Text(text = product.title)
            Text(text = product.price.toString())
        }

    }
}