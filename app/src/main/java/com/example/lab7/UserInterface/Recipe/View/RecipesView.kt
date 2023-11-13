package com.example.lab7.UserInterface.Recipe.View

import androidx.compose.foundation.Image

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.lab7.UserInterface.Filter.View.cards
import com.example.lab7.UserInterface.Meal
import com.example.lab7.UserInterface.Recipe.ViewModel.DetailViewModel
import com.example.lab7.UserInterface.Recipe.ViewModel.RecipesViewModel
import com.example.lab7.networking.response.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeView(navController: NavController, id : String?){
    val i = id.orEmpty()
    val viewmodel: DetailViewModel = viewModel()
    viewmodel.name = i
    val rememberedMeals: Meal = viewmodel.Meal

    Scaffold(
        topBar = {
            TopAppBar(title = {
                androidx.compose.material.Text(text = "Detalle", textAlign = TextAlign.Center, fontSize = 25.sp)
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
        Box(modifier = Modifier.padding(innerPadding)) {
            content(rememberedMeals)
        }



}
}

@Composable
fun content(arg: Meal){

    LazyColumn(){
        item {

            Text(arg.name, fontSize = 25.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp))
            Spacer(modifier = Modifier.padding(10.dp))
            Text(arg.instructions, fontSize = 15.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp))

        }

    }

}







