package com.example.lab7.UserInterface.Recipe.Model

import com.example.lab7.networking.MealsWebService
import com.example.lab7.networking.response.Recipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesRepository(private val webService: MealsWebService = MealsWebService()){
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
                // TODO treat failure
            }
        })
    }

}

/*

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
 */