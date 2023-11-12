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
import com.example.lab7.UserInterface.Filter.ViewModel.RecipesViewModel
import com.example.lab7.UserInterface.Meal


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsFilter(navController: NavController, category: String?) {

    val cat = category.orEmpty()

    val viewmodel: RecipesViewModel = viewModel()
    viewmodel.category = cat
    val rememberedMeals = viewmodel.recipeList.value
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
            items(rememberedMeals) { meal ->
                cards(meal, navController)
            }
        }

    }
}


@Composable
fun cards(arg: Meal, navController: NavController){
    Card(modifier = Modifier
        .background(color = Color.LightGray, shape = RectangleShape)
        .border(2.dp, Color.Black, RectangleShape)
        .clickable(onClick = {navController.navigate("detail/${arg.name}")})
        .fillMaxWidth()
        .height(60.dp)){
        Row(){
            Image(painter = rememberAsyncImagePainter(model = arg.image), contentDescription = "Food" )
            Text(arg.name)

        }

    }


}