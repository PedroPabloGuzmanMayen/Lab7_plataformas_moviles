package com.example.lab7.networking

import com.example.lab7.networking.response.Meals
import com.example.lab7.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface MealsApi {
    @GET("categories.php")
    fun getMeals(): Call<MealsCategoriesResponse>
    @GET("filter.php?c=Seafood")
    fun getSeaFood(): Call<Meals>

}