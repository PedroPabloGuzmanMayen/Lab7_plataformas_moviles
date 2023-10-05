package com.example.lab7.UserInterface.Filter.ViewModel

import androidx.lifecycle.ViewModel
import com.example.lab7.networking.response.MealRes
import com.example.lab7.UserInterface.Filter.Model.FilterRepository
import com.example.lab7.networking.response.Meals


class MealsFilterViewModel(private val repository: FilterRepository = FilterRepository()): ViewModel() {

    fun getSeaFood(category: String, successCallback: (response: Meals?) -> Unit) {
        repository.getSeaFood(category) { response ->
            successCallback(response)
        }
    }
}