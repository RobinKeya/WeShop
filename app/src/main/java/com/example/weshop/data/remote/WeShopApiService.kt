package com.example.weshop.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface WeShopApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id:Int): Product
    @GET("products/categories")
    suspend fun getCategories(): List<String>

}