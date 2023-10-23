package com.zezzi.eventzezziapp.ui.food

import com.zezzi.eventzezziapp.data.networking.response.FoodResponse

data class StateFood} (
    val food: List<FoodResponse>,
    val loading: Boolean = false
)
