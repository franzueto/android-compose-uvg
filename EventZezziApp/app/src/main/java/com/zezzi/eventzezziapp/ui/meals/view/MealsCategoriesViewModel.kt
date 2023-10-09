package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.repository.MealsRepository
import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import android.util.Log

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            val response = repository.getMeals()
            Log.d("MealsCategoriesViewModel", "Response: $response")
            response
        } catch (e: Exception) {

            null
        }
    }
}