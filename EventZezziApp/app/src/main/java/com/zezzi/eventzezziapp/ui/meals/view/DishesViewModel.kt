package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.launch
import java.util.Locale.Category

class DishesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {
    var dishUiState by mutableStateOf(MealsCategoryUiState(emptyList()))
        private set

    fun getDishesByCategory(category: String) {
        viewModelScope.launch {
            dishUiState = MealsCategoryUiState(repository.getMeals(Category))
        }
    }
}
