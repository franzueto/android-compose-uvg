package com.zezzi.eventzezziapp.ui.meals.view

import android.util.Log
import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.IngredientsRepository

class IngredientsCategoriesViewModel(private val repository: IngredientsRepository = IngredientsRepository()): ViewModel()  {
    suspend fun getIngredients(dishId: String): IngredientsCategoriesResponse? {
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