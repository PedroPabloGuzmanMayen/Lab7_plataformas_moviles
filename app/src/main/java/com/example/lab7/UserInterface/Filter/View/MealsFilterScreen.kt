package com.example.lab7.UserInterface.Filter.View

import com.example.lab7.UserInterface.Filter.ViewModel.MealsFilterViewModel
import com.example.lab7.networking.response.MealRes

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
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsFilter(navController: NavController, category: String?) {
    val viewmodel: MealsFilterViewModel = viewModel()
    val cat = category.orEmpty()
    val rememberedMeals: MutableState<List<MealRes>> = remember { mutableStateOf(emptyList<MealRes>()) }
    viewmodel.getSeaFood(cat){ response ->
        val mealsFromTheApi = response?.meals
        rememberedMeals.value = mealsFromTheApi.orEmpty()

    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Recetas", textAlign = TextAlign.Center, fontSize = 25.sp)
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Magenta),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                })


        }
    ){ innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(rememberedMeals.value) { meal ->
                cards(meal, navController)
            }
        }

    }
}


@Composable
fun cards(arg: MealRes, navController: NavController){
    Card(modifier = Modifier
        .background(color = Color.LightGray, shape = RectangleShape)
        .border(2.dp, Color.Black, RectangleShape)
        .clickable(onClick = {navController.navigate("detail/${arg.id}")})
        .fillMaxWidth()
        .height(60.dp)){
        Row(){
            Image(painter = rememberAsyncImagePainter(model = arg.mealThumb), contentDescription = "Food" )
            Text(arg.meal)

        }

    }


}