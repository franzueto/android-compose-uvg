package com.zezzi.eventzezziapp.navigation

sealed class NavigationState(val route: String) {
    object Category: NavigationState("Category")
    object RecipeScreen: NavigationState("RecipeScreen")
}