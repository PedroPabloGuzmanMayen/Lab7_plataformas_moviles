package com.example.lab7.Navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab7.UserInterface.Meals.MealsCategoriesScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.MealsCategories.route){
        composable(route = AppScreen.MealsCategories.route){
            MealsCategoriesScreen()
        }
    }
}