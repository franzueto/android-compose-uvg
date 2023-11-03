package com.zezzi.eventzezziapp.ui.meals.view

import androidx.lifecycle.ViewModel
import android.util.Log
import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository


class IngredientsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getIngredients(dishId:String): IngredientsCategoriesResponse? {
        return try {
            val response = repository.getIngredients(dishId)
            // Agregar registro de depuración para verificar la respuesta
            Log.d("IngredientsCategoriesViewModel", "Response: $response")
            response
        } catch (e: Exception) {
            // Manejar errores si es necesario.
            null
        }
    }
}
