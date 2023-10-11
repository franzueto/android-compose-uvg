package com.zezzi.eventzezziapp.ui.meals.view

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {

    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            val response = repository.getMeals()
            Log.d("Enter: MealsCategoriesViewModel, wait...", "Response: $response")
            response
        } catch (e: Exception) {
            null
        }
    }
}
