package com.example.lab7.UserInterface.Recipe.Model


import com.example.lab7.networking.MealsWebService
import com.example.lab7.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getRecipe(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        return webService.getMeals().enqueue(object : Callback<MealsCategoriesResponse> {
            override fun onResponse(
                call: Call<MealsCategoriesResponse>,
                response: Response<MealsCategoriesResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}
