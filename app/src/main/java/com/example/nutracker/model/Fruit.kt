package com.example.nutracker.model

data class Fruit(
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
