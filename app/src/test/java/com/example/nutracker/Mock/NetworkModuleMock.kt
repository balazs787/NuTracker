package com.example.nutracker.Mock

import com.example.nutracker.di.NetworkModule
import com.example.nutracker.network.NutrackerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModuleMock {
    private val networkModule = NetworkModule()

    @Provides
    @Singleton
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        builder.interceptors().add(builder.interceptors().size, InterceptorMock())

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return networkModule.provideRetrofit(client)
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): NutrackerService {
        return networkModule.provideService(retrofit)
    }
}