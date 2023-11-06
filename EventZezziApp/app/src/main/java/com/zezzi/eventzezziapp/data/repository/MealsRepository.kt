package com.zezzi.eventzezziapp.data.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.DishesCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.DishesResponse
import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    private val db = Firebase.firestore

    suspend fun getMeals(): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            val documents = db.collection("Meals")
                .get().await().documents

            val mealResponses = documents.map {
                MealResponse(
                    it.id,
                    it.getString("name") ?: "",
                    it.getString("description") ?: "",
                    it.getString("imageUrl") ?: ""
                )
            }

            MealsCategoriesResponse(mealResponses)
        }
    }


    suspend fun getDishes(mealName: String): DishesCategoriesResponse {
        return withContext(Dispatchers.IO) {
            //Se bajan todos los documentos de la coleccion Meals
            val documents = db.collection("Meals")
                .document(mealName).collection("Dishes")
                .get().await().documents

            DishesCategoriesResponse(
                documents.map {
                    DishesResponse(
                        it.getString("id1") ?: "",
                        it.getString("name1") ?: "",
                        it.getString("imageUrl1") ?:
                        it.id
                    )
                }
            )
        }
    }


    suspend fun getIngredients(dishId: String): IngredientsCategoriesResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = webService.getIngredients(dishId)
                Result.success(response).getOrNull()
            } catch (e: Exception) {
                // Manejar errores si es necesario.
                null
            }
        }
    }
}


