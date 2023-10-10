package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return withContext(Dispatchers.IO) {
            try {
                // El resultado de la solicitud de red se almacena en la variable meals
                val response = webService.getMeals()
                Result.success(response).getOrNull()

            } catch (e: Exception) {
                // Maneja la excepción de tiempo de espera aquí
                null
            }
        }
    }
}