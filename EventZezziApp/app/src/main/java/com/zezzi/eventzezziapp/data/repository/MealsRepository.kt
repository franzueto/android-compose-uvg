package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return withContext(Dispatchers.IO) {

            try {
                val response = webService.getMeals()
                Result.success(response).getOrNull()

            } catch (e: Exception) {
                null
            }
        }
    }
}
