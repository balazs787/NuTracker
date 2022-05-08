package com.example.nutracker.di

import android.app.Application
import androidx.room.Room
import com.example.nutracker.R
import com.example.nutracker.persistence.AppDatabase
import com.example.nutracker.persistence.NutrackerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                "app_database"
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideNutrackerDao(appDatabase: AppDatabase): NutrackerDao {
        return appDatabase.nutrackerDao()
    }
}