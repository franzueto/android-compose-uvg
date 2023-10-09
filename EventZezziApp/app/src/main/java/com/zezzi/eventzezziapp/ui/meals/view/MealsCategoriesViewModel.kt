package com.zezzi.eventzezziapp.ui.meals.view

import android.util.Log
import androidx.lifecycle.ViewModel
import MealsRepository
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.WithContext
import kotlinx.coroutines.Dispatchers


class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            val response = repository.getMeals()
            Log.d("MealsCategoriesViewModel", "Response: $response")
            response
        } catch (e: Exception){
            printf("Error en el sistema")
            null
        }
    }
}