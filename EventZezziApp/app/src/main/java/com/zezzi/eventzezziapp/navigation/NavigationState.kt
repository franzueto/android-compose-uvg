package com.zezzi.eventzezziapp.navigation

sealed class NavigationState(val route: String) {

    object Categories: NavigationState("Categories")
    object FoodScreen: NavigationState("Food")
    object RecipesScreen: NavigationState("RecipesScreen")
}