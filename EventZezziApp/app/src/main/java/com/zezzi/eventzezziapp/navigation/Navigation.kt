package com.zezzi.eventzezziapp.navigation

import com.zezzi.eventzezziapp.ui.recipies.MealsScreen
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoriesScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationState.Categories.route,
        modifier = modifier
    ) {
        composable(route = NavigationState.Categories.route) {
            MealsCategoriesScreen(navController)
        }
        composable(route = NavigationState.RecipesScreen.route + "/{category}") { backstackEntry ->
            MealsScreen(navController, backstackEntry.arguments?.getString("category") ?: "")
        }
    }
}