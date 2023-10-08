package com.zezzi.eventzezziapp.ui.meals.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {

    fun getMeals() {
        viewModelScope.launch {
            val response = repository.getMeals()
            println("Obtained response: $response") //print for testing
        }
    }
}