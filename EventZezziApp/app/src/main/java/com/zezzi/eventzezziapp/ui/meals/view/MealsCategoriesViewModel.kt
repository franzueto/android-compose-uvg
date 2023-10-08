package com.zezzi.eventzezziapp.ui.meals.view

import MealsRepository
import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            repository.getMeals()
        } catch (e: Exception) {
            // Manejar errores si es necesario.
            null
        }
    }
}



