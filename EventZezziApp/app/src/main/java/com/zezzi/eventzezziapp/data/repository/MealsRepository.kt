package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(category: String): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            webService.getMeals()
        }
    }
}