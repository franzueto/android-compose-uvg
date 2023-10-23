package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.networking.response.MealDetailResponse
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {

    val meals: MutableState<List<MealResponse>> = mutableStateOf(emptyList())

    val mealsByCategory: MutableState<List<MealDetailResponse>> = mutableStateOf((emptyList()))

    val isLoading = mutableStateOf(false)

    fun getMeals() {
        viewModelScope.launch {
            val response = repository.getMeals()
            meals.value = response.categories
        }
    }

    fun getMealsByCategory(category: String){
        viewModelScope.launch {
            try {
                isLoading.value = true
                val response = repository.getMealsByCategory(category)
                mealsByCategory.value = response.meals
            }catch (e: Exception){
                // Handle Error
            }
            finally {
                isLoading.value = false
            }
        }
    }

}