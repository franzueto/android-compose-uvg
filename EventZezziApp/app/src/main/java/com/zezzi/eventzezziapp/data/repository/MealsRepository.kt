package com.zezzi.eventzezziapp.data.repository

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.zezzi.eventzezziapp.data.networking.response.MealDetailResponse
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsByCategoryResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MealsRepository {

    private val db = Firebase.firestore

    suspend fun getMeals(): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {

            val categories = db.collection("Categorias").get().await()

            MealsCategoriesResponse(
                categories.map {
                    MealResponse(
                        it.id,
                        it.getString("categoria") ?: "",
                        it.getString("descripcion") ?:"",
                        it.getString("url") ?: ""
                    )
                }
            )
        }
    }

    suspend fun getMealsByCategory(category: String): MealsByCategoryResponse {
        return withContext(Dispatchers.IO) {
            // Get ref for recipes subcolection based on given category
            val recipeRef = db.collection("Categorias").document(category).collection("Recetas")

            // Get recipe data
            val recipe = recipeRef.get().await()

            MealsByCategoryResponse(
                recipe.documents.map { document ->
                    MealDetailResponse(
                        document.id,
                        document.getString("receta") ?: "",
                        document.getString("url") ?: ""
                    )
                }
            )
        }
    }
}