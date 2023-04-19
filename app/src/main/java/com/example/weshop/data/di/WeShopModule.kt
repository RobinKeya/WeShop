package com.example.weshop.data.di

import com.example.weshop.data.remote.WeShopApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object WeShopModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        val moshi = Moshi.Builder().build()
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    @Provides
    fun provideWeShopApiInstance(retrofit: Retrofit): WeShopApiService {
        return retrofit.create(WeShopApiService::class.java)
    }
}