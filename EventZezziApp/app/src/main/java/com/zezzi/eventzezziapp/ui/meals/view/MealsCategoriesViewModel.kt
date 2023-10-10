package com.zezzi.eventzezziapp.ui.meals.view

import android.util.Log
import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            val response = repository.getMeals()
            // Si la respuesta es exitosa, se imprime en el Logcat
            Log.d("MealsCategoriesViewModel", "Response: $response")
            response
        } catch (e: Exception) {
            null
        }
    }
}