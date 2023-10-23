package com.zezzi.eventzezziapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoriesScreen
import com.zezzi.eventzezziapp.ui.recipes.view.RecipeScreen

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
        composable(route = NavigationState.RecipesScreen.route + "/{cat}"){
                backstackEntry ->  RecipeScreen(navController, backstackEntry.arguments?.getString("category") ?: "")
        }
    }
}