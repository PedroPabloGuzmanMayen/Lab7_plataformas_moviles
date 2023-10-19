package com.example.lab7.UserInterface.Recipe.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.lab7.UserInterface.Recipe.ViewModel.RecipesViewModel
import com.example.lab7.networking.response.Recipe

@Composable
fun RecipeView(){
    val viewmodel: RecipesViewModel = viewModel()
    val rememberedMeals: MutableState<List<Recipe>> = remember { mutableStateOf(emptyList<Recipe>()) }
    viewmodel.getRecipe("52918"){ response ->
        val mealsFromTheApi = response?.meals
        rememberedMeals.value = mealsFromTheApi.orEmpty()

    }

    LazyColumn()
    {
        items(rememberedMeals.value) { meal ->
            Text(meal.name)
        }
    }

}



