package com.example.nutracker.di

import com.example.nutracker.network.NutrackerService
import com.example.nutracker.persistence.NutrackerDao
import com.example.nutracker.ui.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideNutrackerService(nutrackerService: NutrackerService,nutrackerDao: NutrackerDao): MainRepository {
        return MainRepository(nutrackerService,nutrackerDao)
    }
}