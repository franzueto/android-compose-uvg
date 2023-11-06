package com.zezzi.eventzezziapp.data.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.zezzi.eventzezziapp.data.networking.response.CategoryResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MealsRepository2 {

    val db = Firebase.firestore

    suspend fun getCategories(): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            val documents = db.collection("Meals")
                //.whereEqualTo("name", "Beef")
                .get().await().documents

            MealsCategoriesResponse(
                documents.map {
                    CategoryResponse(
                        it.id,
                        it.getString("name") ?: "",
                        it.getString("description") ?: "",
                        it.getString("imageUrl") ?: ""
                    )
                }
            )
        }
    }
}