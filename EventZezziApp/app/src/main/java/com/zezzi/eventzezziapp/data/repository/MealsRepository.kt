package com.zezzi.eventzezziapp.data.repository
import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.WithContext
import kotlinx.coroutines.Dispatchers
import com.zezzi.eventzezziapp.data.networking.response.RecipesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            webService.getMeals()
        }
    }
}