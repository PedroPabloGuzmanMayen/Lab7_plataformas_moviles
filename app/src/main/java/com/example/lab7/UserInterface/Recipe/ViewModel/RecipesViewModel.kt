package com.example.lab7.UserInterface.Recipe.ViewModel

import androidx.lifecycle.ViewModel
import com.example.lab7.UserInterface.Recipe.Model.RecipesRepository
import com.example.lab7.networking.response.Recipes

class RecipesViewModel(private val repository: RecipesRepository = RecipesRepository()): ViewModel() {

    fun getRecipe(id: String, successCallback: (response: Recipes?) -> Unit) {
        repository.getRecipe(id) { response ->
            successCallback(response)
        }

    }
}

/*
class MealsFilterViewModel(private val repository: FilterRepository = FilterRepository()): ViewModel() {

    fun getSeaFood(category: String, successCallback: (response: Meals?) -> Unit) {
        repository.getSeaFood(category) { response ->
            successCallback(response)
        }
    }
}
 */