package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.MealResponse

data class MealsCategoryUiState(
    val categories: List<MealResponse>,
    val loading: Boolean = false
)