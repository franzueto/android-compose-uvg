package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.CategoryResponse

data class MealsCategoryUiState(
    val categories: List<CategoryResponse>,
    val loading: Boolean = false
)