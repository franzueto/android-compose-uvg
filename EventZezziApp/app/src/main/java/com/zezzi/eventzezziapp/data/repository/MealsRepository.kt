package com.zezzi.eventzezziapp.data.repository
import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.WithContext
import kotlinx.coroutines.Dispatchers
import com.zezzi.eventzezziapp.data.networking.response.FoodResponse
import com.zezzi.eventzezziapp.data.networking.response.FoodResponseComplete
import com.zezzi.eventzezziapp.data.networking.response.RecipesR

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return withContext(Dispatchers.IO) {
            webService.getMeals()
        }
    }
    suspend fun getRecipes(category: String): RecipesR {
        return withContext(Dispatchers.IO){
            webService.getRecipes(category)
        }
    }
    suspend fun getFood(name: String): FoodResponseComplete {
        return withContext(Dispatchers.IO) {
            webService.getFood(name)
        }
    }
}