package com.example.lab7.UserInterface.Meals.ViewModel
import androidx.lifecycle.ViewModel
import com.example.lab7.networking.response.MealsCategoriesResponse
import com.example.lab7.UserInterface.Meals.Model.MealsRepository


class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}