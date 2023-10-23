package com.zezzi.eventzezziapp.ui.meals.view


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    var meals by mutableStateOf(MealsCategoriesState(emptyList()))
        private set
    fun getMeals() {
        meals = MealsCategoriesState(emptyList())
        viewModelScope.launch {
            meals = MealsCategoriesState(repository.getMeals().categories)
        }
    }
}