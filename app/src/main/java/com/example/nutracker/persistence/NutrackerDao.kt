package com.example.nutracker.persistence

import androidx.room.*
import com.example.nutracker.model.Fruit

@Dao
interface NutrackerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFruit(fruit: Fruit)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateFruit(fruit: Fruit)

    @Delete
    fun deleteFruit(fruit: Fruit)

    @Query("SELECT * FROM Fruit")
    fun getFruits(): List<Fruit>

    @Query("SELECT * FROM Fruit WHERE name = :name")
    fun findById(name: String): Fruit?
}