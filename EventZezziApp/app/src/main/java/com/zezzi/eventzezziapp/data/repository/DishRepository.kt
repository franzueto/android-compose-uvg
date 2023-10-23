package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.DishWebService
import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.DishCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DishRepository(private val webService: DishWebService = DishWebService()) {
    suspend fun getDishes(mealName: String): DishCategoriesResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = webService.getDishes(mealName)
                Result.success(response).getOrNull()
            } catch (e: Exception) {
                // Manejar errores si es necesario.
                null
            }
        }
    }



}