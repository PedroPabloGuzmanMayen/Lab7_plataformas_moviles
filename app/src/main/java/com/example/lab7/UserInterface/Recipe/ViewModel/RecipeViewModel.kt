package com.example.lab7.UserInterface.Recipe.ViewModel

import androidx.lifecycle.ViewModel
import com.example.lab7.UserInterface.Recipe.Model.RecipeRepository
import com.example.lab7.networking.response.Recipes

class RecipeViewModel(private val repository: RecipeRepository = RecipeRepository()): ViewModel() {

    fun getRecipe(id: String, successCallBack: (response: Recipes?) -> Unit) {

        repository.getRecipe(id){ response ->
            successCallBack(response)

        }
    }
}

