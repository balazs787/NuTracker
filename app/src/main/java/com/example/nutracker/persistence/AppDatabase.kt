package com.example.nutracker.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nutracker.model.Fruit

@Database(entities = [Fruit::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun nutrackerDao(): NutrackerDao
}