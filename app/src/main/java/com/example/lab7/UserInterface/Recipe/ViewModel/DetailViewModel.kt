package com.example.lab7.UserInterface.Recipe.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.UserInterface.FirestoreRepository
import com.example.lab7.UserInterface.Meal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: FirestoreRepository = FirestoreRepository()): ViewModel() {

    var name: String = ""
    var Meal : Meal = Meal(name = "", instructions = "", image = "")
    init {
        viewModelScope.launch(Dispatchers.IO){
            val recipe = repository.getRecipeDetail(name)
            Meal.name = recipe.name
            Meal.instructions = recipe.instructions
            Meal.image = recipe.image

        }

    }

}