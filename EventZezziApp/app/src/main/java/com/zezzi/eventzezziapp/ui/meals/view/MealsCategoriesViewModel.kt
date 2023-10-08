package com.zezzi.eventzezziapp.ui.meals.view

import MealsRepository
import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.util.Log


class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            val response = repository.getMeals()
            // Agregar registro de depuración para verificar la respuesta
            Log.d("MealsCategoriesViewModel", "Response: $response")
            response
        } catch (e: Exception) {
            // Manejar errores si es necesario.
            null
        }
    }
}



