package com.example.lab7.UserInterface.Meals

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
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
import com.example.lab7.networking.response.MealResponse


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>()) }

    viewModel.getMeals { response ->
        val mealsFromTheApi = response?.categories
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Categorias", textAlign = TextAlign.Center, fontSize = 25.sp)
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Magenta))
        }
    ){ innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(rememberedMeals.value) { meal ->
                Text(text = meal.name)
            }
        }

    }


}

@Composable
fun slides(arg: MealResponse){
    Card(modifier = Modifier.background(color = Color.LightGray, shape = RectangleShape)
        .border(2.dp, Color.Black, RectangleShape)
        .clickable(onClick ={})){
        Row(){

        }

    }



}