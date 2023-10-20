package com.example.lab7.Navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab7.UserInterface.Filter.View.MealsFilter
import com.example.lab7.UserInterface.Meals.View.MealsCategoriesScreen
import com.example.lab7.UserInterface.Recipe.View.RecipeView

@Composable
fun AppNavigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.MealsCategories.route){
        composable(route = AppScreen.MealsCategories.route){
            MealsCategoriesScreen(navController)
        }
        composable(route = AppScreen.Filter.route + "/{category}",
        arguments = listOf(navArgument(name = "category") {
            type = NavType.StringType }
        )
        ){backStackEntry ->
            MealsFilter(navController, category = backStackEntry.arguments?.getString("category") )
        }
        composable(route = AppScreen.Detail.route + "/{id}",
            arguments = listOf(navArgument(name = "id") {
                type = NavType.StringType }
            )){backStackEntry ->
            RecipeView(navController, id = backStackEntry.arguments?.getString("id"))
        }
    }
}