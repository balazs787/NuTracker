package com.example.nutracker.ui.main

import androidx.annotation.WorkerThread
import com.example.nutracker.model.Fruit
import com.example.nutracker.network.NutrackerService
import com.example.nutracker.persistence.NutrackerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val nutrackerService: NutrackerService,
    private val nutrackerDao: NutrackerDao
){
    @WorkerThread
    fun loadFruits(onStart: () -> Unit, onCompletion: () -> Unit) = flow {
        val fruits: List<Fruit>? = nutrackerService.getFruits().execute().body()
        emit(fruits)
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)

    fun add(fruit: Fruit) {
        //GlobalScope.launch{ nutrackerDao.insertFruit(fruit) }
    }

    fun delete(fruit: Fruit) {
        //GlobalScope.launch{ nutrackerDao.deleteFruit(fruit) }
    }
}