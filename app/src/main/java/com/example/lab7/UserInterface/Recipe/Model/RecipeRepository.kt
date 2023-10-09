package com.example.lab7.UserInterface.Recipe.Model


import android.util.Log
import com.example.lab7.networking.MealsWebService
import com.example.lab7.networking.response.Recipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getRecipe(id: String, successCallback: (response: Recipes?) -> Unit) {
        return webService.getRecipe(id).enqueue(object : Callback<Recipes> {
            override fun onResponse(
                call: Call<Recipes>,
                response: Response<Recipes>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                Log.e("RecipeViewModel", "Failed to fetch recipe: ${t.message}")
            }
        })
    }
}
