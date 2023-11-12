package com.example.lab7.UserInterface.Meals.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.UserInterface.Categories
import com.example.lab7.UserInterface.FirestoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel(private val repository: FirestoreRepository = FirestoreRepository()): ViewModel() {
    val categoriyList: MutableState<List<Categories>> = mutableStateOf(emptyList<Categories>())

    init {
        viewModelScope.launch(Dispatchers.IO){
            val categories = repository.getCategories()
            categoriyList.value = categories
        }
    }
}