package com.zezzi.eventzezziapp.ui.meals.view

import com.zezzi.eventzezziapp.data.networking.response.Meal


data class MealsUiState(
    val meals: List<Meal>,
    val loading: Boolean = false
)