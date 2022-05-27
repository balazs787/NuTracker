package com.example.nutracker.ui.main

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nutracker.model.Fruit
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
): ViewModel(){
    @Inject lateinit var mainRepository: MainRepository;

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading

    private val _details: MutableState<Boolean> = mutableStateOf(false)
    val details: State<Boolean> get() = _details

    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    private val _selectedFruit: MutableState<Fruit> = mutableStateOf(Fruit())
    val selectedFruit: State<Fruit> get() = _selectedFruit

    private val _title: MutableState<String> = mutableStateOf("Fruits")
    val title: State<String> get() = _title

    private val firebaseAnalytics = Firebase.analytics;

    val fruitList: Flow<List<Fruit>?> =
        mainRepository.loadFruits(
            onStart = { _isLoading.value = true },
            onCompletion = { _isLoading.value = false }
        )

    fun selectFruit(tab: Int, fruit: Fruit) {
        _selectedTab.value = tab;
        _selectedFruit.value = fruit;
        _title?.value = fruit?.name?:"";
        _details.value = true;

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "selectFruit")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Select fruit and show details: ${_selectedFruit.value.name}")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)
    }

    fun deleteClicked(){
        //mainRepository.delete(fruit);
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "deleteFruit")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Delete fruit: ${_selectedFruit.value.name}")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.REMOVE_FROM_CART, bundle)
    }

    fun backClicked(){
        _selectedTab.value = 0;
        _title.value = "Fruit";
        _details.value = false;
    }

    fun addClicked(){
        _selectedTab.value = 1;
        _title.value = "Add fruit";
        _selectedFruit.value = Fruit();
        _details.value = true;
    }

    fun saveClicked(){
        mainRepository.add(_selectedFruit.value);
        _title.value = "Fruit";
        _details.value = false;
        _selectedTab.value = 0;

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "saveFruit")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Save fruit to list: ${_selectedFruit.value.name}")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.ADD_TO_CART, bundle)
    }


    fun selectTab(@StringRes tab: Int) {
        _selectedTab.value = tab
    }

    fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }
}