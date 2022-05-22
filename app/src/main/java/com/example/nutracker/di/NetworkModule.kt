package com.example.nutracker.di

import android.content.Context
import com.example.nutracker.extensions.FruitSerialize
import com.example.nutracker.model.Fruit
import com.example.nutracker.network.NutrackerService
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val json = GsonBuilder().registerTypeAdapter(Fruit::class.java,FruitSerialize()).create()


    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(
                NetworkConfig.SERVICE_ENDPOINT
            )
            .addConverterFactory(GsonConverterFactory.create(json))
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): NutrackerService {
        return retrofit.create(NutrackerService::class.java)
    }
}