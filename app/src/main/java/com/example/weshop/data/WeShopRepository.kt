package com.example.weshop.data

import com.example.weshop.data.di.IODispatcher
import com.example.weshop.data.remote.Product
import com.example.weshop.data.remote.WeShopApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeShopRepository @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val weShopApiService: WeShopApiService
) {
    suspend fun getProducts(): List<Product>{
        return withContext(dispatcher){
            return@withContext weShopApiService.getProducts()
        }
    }
    suspend fun getProduct(id: Int): Product{
        return withContext(dispatcher){
            return@withContext weShopApiService.getProduct(id)
        }
    }
    suspend fun getCategories(): List<String>{
        return withContext(dispatcher){
            return@withContext weShopApiService.getCategories()
        }
    }
}