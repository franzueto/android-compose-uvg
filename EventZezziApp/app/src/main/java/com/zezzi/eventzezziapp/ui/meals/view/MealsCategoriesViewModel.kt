package com.zezzi.eventzezziapp.ui.meals.view

import MealsRepository
import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return withContext(Dispatchers.IO) {
            try {
                // Llamar a la función suspendida en el repositorio para obtener los datos.
                repository.getMeals()
            } catch (e: Exception) {
                // Manejar errores si es necesario.
                null
            }
        }
    }
}
