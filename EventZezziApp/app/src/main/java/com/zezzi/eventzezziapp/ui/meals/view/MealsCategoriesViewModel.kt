package com.zezzi.eventzezziapp.ui.meals.view

import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    var categories:MutableState<List<MealResponse>> by mutableStateOf(emptyList())
     private set

    fun getMeals() {
        viewModelScope.launch {
            repository.getMeals()
        }
    }
}