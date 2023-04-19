package com.example.weshop.presentations.productDetails

import com.example.weshop.data.remote.Product

data class ProductDetailScreenState(
    val product: Product?=null,
    val isLoading: Boolean,
    val error: String? = null
)
