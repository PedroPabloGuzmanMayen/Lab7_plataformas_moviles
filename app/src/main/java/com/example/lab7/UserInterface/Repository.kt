package com.example.lab7.UserInterface

import com.example.lab7.networking.response.Meals
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


class FirestoreRepository() {
    private val db = FirebaseFirestore.getInstance()

    suspend fun getCategories(): MutableList<Categories> {
        val categories = db.collection("Categories").get().await()
        val allCategories = mutableListOf<Categories>()


        for (category in categories) {
            allCategories.add(
                Categories(
                    name = category.getString("name")!!,
                    image = category.getString("image")!!
                )
            )
        }

        return allCategories
    }

    suspend fun getRecipeList(category: String): MutableList<Meal> {
        val allrecipes = mutableListOf<Meal>()
        val recipes = db.collection("Recipes").whereEqualTo("category", category).get().await()

        for (recipe in recipes){
            allrecipes.add(
                Meal(
                    name = recipe.getString("name")!!,
                    instructions = recipe.getString("instructions")!!,
                    image = recipe.getString("image")!!
                )
            )

        }
        return allrecipes
    }

    suspend fun getRecipeDetail(recipe: String): Meal {


        val query = db.collection("Recipes").document(recipe).get().await()
        val meal: Meal = Meal(
            name = query.getString("name")!!,
            instructions = query.getString("instructions")!!,
            image = query.getString("image")!!
        )
        return meal

    }
}



