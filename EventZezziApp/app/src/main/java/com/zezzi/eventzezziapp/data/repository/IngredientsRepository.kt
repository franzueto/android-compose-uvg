package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.DishWebService
import com.zezzi.eventzezziapp.data.networking.IngredientsWebService
import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.DishCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IngredientsRepository(private val webService: IngredientsWebService = IngredientsWebService()) {
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