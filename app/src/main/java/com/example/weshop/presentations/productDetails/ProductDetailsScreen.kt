package com.example.weshop.presentations.productDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.weshop.R

@Composable
fun ProductDetailsScreen(productDetailScreenState: ProductDetailScreenState) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Text(text =productDetailScreenState.product!!.title )
            Text(text = productDetailScreenState.product.price.toString())
            Text(text = productDetailScreenState.product.description)
            
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(25))
                    .padding(8.dp),
                onClick = { /*TODO*/ }) {
                Text(stringResource(id = R.string.add_to_cart))
            }
        }
    }
}