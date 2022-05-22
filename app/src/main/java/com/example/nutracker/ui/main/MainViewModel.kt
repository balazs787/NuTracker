package com.example.nutracker.ui.main

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nutracker.model.Fruit
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
        println(selectedFruit.toString());
    }

    fun deleteClicked(){
        //mainRepository.delete(fruit);
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
    }


    fun selectTab(@StringRes tab: Int) {
        _selectedTab.value = tab
    }

    fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }
}