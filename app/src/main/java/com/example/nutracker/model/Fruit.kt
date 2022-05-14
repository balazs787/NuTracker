package com.example.nutracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fruit(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val genus: String,
    val name: String,
    val family: String,
    val order: String,
    val carbohydrates: Float,
    val protein: Float,
    val fat: Float,
    val calories: Float,
    val sugar: Float
)
