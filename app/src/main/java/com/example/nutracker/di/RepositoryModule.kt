package com.example.nutracker.di

import com.example.nutracker.network.NutrackerService
import com.example.nutracker.persistence.NutrackerDao
import com.example.nutracker.ui.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideNutrackerService(nutrackerService: NutrackerService,nutrackerDao: NutrackerDao): MainRepository {
        return MainRepository(nutrackerService,nutrackerDao)
    }
}