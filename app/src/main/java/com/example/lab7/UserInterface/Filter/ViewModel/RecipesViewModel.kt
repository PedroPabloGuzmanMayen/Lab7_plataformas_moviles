package com.example.lab7.UserInterface.Filter.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.UserInterface.FirestoreRepository
import com.example.lab7.UserInterface.Meal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Types.NULL

class RecipesViewModel(private val repository: FirestoreRepository = FirestoreRepository()): ViewModel() {

    val recipeList: MutableState<List<Meal>> = mutableStateOf(emptyList<Meal>())
    var category: String = ""



    init {
        viewModelScope.launch(Dispatchers.IO){
            val recipe = repository.getRecipeList(category)
            recipeList.value = recipe
        }

    }
}