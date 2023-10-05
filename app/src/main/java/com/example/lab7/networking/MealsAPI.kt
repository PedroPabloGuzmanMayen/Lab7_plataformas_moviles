package com.example.lab7.networking

import com.example.lab7.networking.response.Meals
import com.example.lab7.networking.response.MealsCategoriesResponse
import com.example.lab7.networking.response.MealRes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    fun getMeals(): Call<MealsCategoriesResponse>
    @GET("filter.php")
    fun getSeaFood(@Query("c") category: String): Call<Meals>

}