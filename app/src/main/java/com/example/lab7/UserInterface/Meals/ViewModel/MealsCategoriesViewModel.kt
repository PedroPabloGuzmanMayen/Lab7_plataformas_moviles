package com.example.lab7.UserInterface.Meals
import androidx.lifecycle.ViewModel
import com.example.lab7.networking.response.MealsCategoriesResponse
import com.example.lab7.UserInterface.Meals.MealsRepository


class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}