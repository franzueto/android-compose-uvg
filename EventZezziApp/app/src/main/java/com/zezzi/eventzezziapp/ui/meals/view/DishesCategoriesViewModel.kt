package com.zezzi.eventzezziapp.ui.meals.view

import androidx.lifecycle.ViewModel
import android.util.Log
import com.zezzi.eventzezziapp.data.networking.response.DishesCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository


class DishesCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getDishes(mealName:String): DishesCategoriesResponse? {
        return try {
            val response = repository.getDishes(mealName)
            // Agregar registro de depuración para verificar la respuesta
            Log.d("DishesCategoriesViewModel", "Response: $response")
            response
        } catch (e: Exception) {
            // Manejar errores si es necesario.
            null
        }
    }
}