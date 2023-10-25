package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getCategories(): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            webService.getCategories()
        }
    }
    suspend fun getMealsByCategory(category: String): MealsResponse {
        return withContext(Dispatchers.IO) {
            webService.getMealsByCategory(category)
        }
    }
}