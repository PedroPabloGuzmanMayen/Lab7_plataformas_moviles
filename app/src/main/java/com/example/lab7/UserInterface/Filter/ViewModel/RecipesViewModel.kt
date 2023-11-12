package com.example.lab7.UserInterface.Filter.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.UserInterface.FirestoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipesViewModel(private val repository: FirestoreRepository = FirestoreRepository(), category: String): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getRecipeList(category)
        }
    }
}