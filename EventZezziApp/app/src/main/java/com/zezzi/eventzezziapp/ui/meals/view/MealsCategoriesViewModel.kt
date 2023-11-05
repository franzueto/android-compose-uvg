package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import com.zezzi.eventzezziapp.data.repository.MealsRepository2
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository2 = MealsRepository2()): ViewModel() {

    var categoryUiState by mutableStateOf(MealsCategoryUiState(emptyList()))
        private set

    fun getMeals() {
        categoryUiState = MealsCategoryUiState(emptyList(), loading = true)

        viewModelScope.launch {
            categoryUiState = MealsCategoryUiState(
                categories = repository.getCategories().categories
            )
        }
    }
}