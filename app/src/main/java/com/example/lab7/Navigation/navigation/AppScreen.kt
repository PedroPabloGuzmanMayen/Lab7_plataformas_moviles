package com.example.lab7.Navigation.navigation

sealed class AppScreen(val route: String){
    object MealsCategories: AppScreen("Categories")
    object Filter: AppScreen("Filter")
    object Detail: AppScreen("Detail")
}
