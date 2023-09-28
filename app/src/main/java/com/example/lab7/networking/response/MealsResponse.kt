package com.example.lab7.networking.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(val categories: List<MealResponse>)
data class Meals(val meals: List<MealRes>)
data class MealResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)

data class MealRes(
    @SerializedName("strMeal") val meal: String,
    @SerializedName("strMealThumb") val mealThumb: String,
    @SerializedName("idMeal") val id: String
)