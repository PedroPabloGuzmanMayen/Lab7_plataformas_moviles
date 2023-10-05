package com.example.lab7.networking
import com.example.lab7.networking.response.MealRes
import com.example.lab7.networking.response.Meals
import com.example.lab7.networking.response.MealsCategoriesResponse
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {

    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    fun getMeals(): Call<MealsCategoriesResponse> {
        return api.getMeals()
    }
    fun getSeaFood(category: String): Call<Meals>{
        return api.getSeaFood(category)
    }
}