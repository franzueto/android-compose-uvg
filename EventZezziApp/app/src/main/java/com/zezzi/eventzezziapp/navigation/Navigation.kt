package com.zezzi.eventzezziapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoriesScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationState.Meals.route,
        modifier = modifier
    ) {
        composable(route = NavigationState.Meals.route) {
            MealsCategoriesScreen(navController)
        }

        composable(
            route = NavigationState.MealsByCategory.route,
            arguments = listOf(navArgument(NavigationState.MealsByCategory.ARG_CATEGORY){type = NavType.StringType})
        ){backStackEntry ->
            val category = backStackEntry.arguments?.getString(NavigationState.MealsByCategory.ARG_CATEGORY)
            // Call screen here with argument (category)
        }
    }
}