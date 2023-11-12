package com.example.lab7.UserInterface.Recipe.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.UserInterface.FirestoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: FirestoreRepository = FirestoreRepository()): ViewModel() {

    var category: String = ""
    var name: String = ""
    init {
        viewModelScope.launch(Dispatchers.IO){
            val recipe = repository.getRecipeDetail(category, name)

        }

    }

}