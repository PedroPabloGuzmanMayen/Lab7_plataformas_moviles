package com.example.lab7.UserInterface.Filter.Model

import com.example.lab7.networking.MealsWebService
import com.example.lab7.networking.response.MealsCategoriesResponse
import com.example.lab7.networking.response.MealRes
import com.example.lab7.networking.response.Meals
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getSeaFood(category: String, successCallback: (response: Meals?) -> Unit) {
        return webService.getSeaFood(category).enqueue(object : Callback<Meals> {
            override fun onResponse(
                call: Call<Meals>,
                response: Response<Meals>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<Meals>, t: Throwable) {
                // TODO treat failure
            }
        })
    }

}