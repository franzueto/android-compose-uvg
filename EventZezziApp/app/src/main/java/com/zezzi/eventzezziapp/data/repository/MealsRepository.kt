package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.DishesCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return withContext(Dispatchers.IO) {
            try {
                // Llamar a la función suspendida en el webService para obtener los datos.
                webService.getMeals()
            } catch (e: Exception) {
                // Manejar errores si es necesario.
                null
            }
        }
    }

    suspend fun getDishes(mealName:String): DishesCategoriesResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = webService.getDishes(mealName)
                Result.success(response).getOrNull()
            } catch (e: Exception) {
                // Manejar errores
                null
            }
        }
    }

    suspend fun getIngredients(dishId:String): IngredientsCategoriesResponse? {
        return withContext(Dispatchers.IO){
            try{
                val response = webService.getIngredients(dishId)
                Result.success(response).getOrNull()
            } catch (e: Exception) {
                null
            }
        }
    }
}

