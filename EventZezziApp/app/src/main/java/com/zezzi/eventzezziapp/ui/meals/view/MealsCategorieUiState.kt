package com.zezzi.eventzezziapp.ui.meals.view

import coil.compose.AsyncImagePainter
import com.zezzi.eventzezziapp.data.networking.response.MealResponse

data class MealsCategorieUiState (
    val categories: List<MealResponse>
)