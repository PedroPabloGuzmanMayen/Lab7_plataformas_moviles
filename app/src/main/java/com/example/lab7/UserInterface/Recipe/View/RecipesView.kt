package com.example.lab7.UserInterface.Recipe.View

import androidx.compose.foundation.Image

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.lab7.UserInterface.Recipe.ViewModel.RecipesViewModel
import com.example.lab7.networking.response.Recipe

@Composable
fun RecipeView(id : String){
    val viewmodel: RecipesViewModel = viewModel()
    val rememberedMeals: MutableState<List<Recipe>> = remember { mutableStateOf(emptyList<Recipe>()) }
    viewmodel.getRecipe(id){ response ->
        val mealsFromTheApi = response?.meals
        rememberedMeals.value = mealsFromTheApi.orEmpty()

    }

    LazyColumn()
    {
        items(rememberedMeals.value) { meal ->
            Image(painter = rememberAsyncImagePainter(model = meal.imageUrl), contentDescription = null )
        }
    }

}

@Composable
fun content(arg: Recipe){
    Image(painter = rememberAsyncImagePainter(model = arg.imageUrl), contentDescription = null )
    Text(arg.instructions)
}







