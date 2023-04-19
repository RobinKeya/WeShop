package com.example.weshop.presentations.productsList

import com.example.weshop.data.remote.Product

data class ProductListScreenState(
    val products : List<Product>,
    val categories : List<String>,
    val isLoading : Boolean,
    val error: String? = null
)
