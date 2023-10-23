package com.zezzi.eventzezziapp.ui.recipies

import com.zezzi.eventzezziapp.data.networking.response.RecipeResponse

data class RecipesUiState(
    val recipes: List<RecipeResponse>,
    val loading: Boolean = false
)