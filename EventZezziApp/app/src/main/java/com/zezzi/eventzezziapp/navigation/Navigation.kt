package com.zezzi.eventzezziapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoriesScreen
import com.zezzi.eventzezziapp.ui.recipies.RecipeScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationState.Category.route,
        modifier = modifier
    ) {
        composable(route = NavigationState.Category.route) {
            MealsCategoriesScreen(navController)
        }
        composable(route = NavigationState.RecipeScreen.route + "/{cat}"){
                backstackEntry ->  RecipeScreen(navController, backstackEntry.arguments?.getString("category") ?: "")
        }
    }
}