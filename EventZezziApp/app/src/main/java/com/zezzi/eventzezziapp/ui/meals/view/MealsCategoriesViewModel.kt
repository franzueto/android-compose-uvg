package com.zezzi.eventzezziapp.ui.meals.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


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