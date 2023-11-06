package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.launch

class MealsViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {

    var mealsUiState by mutableStateOf(MealsUiState(emptyList()))
        private set

    fun getMealsByCategory(category: String) {
        mealsUiState = MealsUiState(emptyList(), loading = true)

        viewModelScope.launch {
            mealsUiState = MealsUiState(
                meals = repository.getMealsByCategory(category).meals
            )
        }
    }
}
