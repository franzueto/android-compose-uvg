package com.zezzi.eventzezziapp.navigation

sealed class NavigationState(val route: String) {
    object Meals: NavigationState("Meals")
    object MealsByCategory: NavigationState("Meals_by/{category}"){
        const val ARG_CATEGORY = "category"
    }
}