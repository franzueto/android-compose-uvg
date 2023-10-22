package com.zezzi.eventzezziapp.ui.meals.view

import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    var categoryUiState by mutableStateOf(MealsCategoryUiState(emptyList()))
        private set

    fun getMeals() {
        categoryUiState = MealsCategoryUiState(emptyList(), loading = true)
        viewModelScope.launch {
            categoryUiState = MealsCategoryUiState(
                categories = repository.getMeals().categories
            )
        }
    }
}

//REVISAR!