package com.example.lab7.UserInterface.Recipe.View

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab7.UserInterface.Recipe.ViewModel.RecipeViewModel
import com.example.lab7.networking.response.Recipe
import androidx.compose.foundation.lazy.items


@Composable
fun RecipeScreen(){
    val viewModel: RecipeViewModel = viewModel()
    val rememberedRecipes: MutableState<List<Recipe>> = remember { mutableStateOf(emptyList<Recipe>()) }
    viewModel.getRecipe("52944"){ response ->
        val mealsFromTheApi = response?.recipes
        rememberedRecipes.value = mealsFromTheApi.orEmpty()

    }

    LazyColumn(){
        items(rememberedRecipes.value){ recipe ->
            Text(recipe.name)
        }
    }

    


}
