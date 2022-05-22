package com.example.nutracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fruit(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String? = null,
    val family: String? = null,
    val genus: String? = null,
    val order: String? = null,
    val calories: Float? = null,
    val carbohydrates: Float? = null,
    val protein: Float? = null,
    val fat: Float? = null,
)
