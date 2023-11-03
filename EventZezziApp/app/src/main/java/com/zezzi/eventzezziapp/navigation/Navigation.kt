package com.zezzi.eventzezziapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoriesScreen
import com.zezzi.eventzezziapp.ui.meals.view.DishesCategoriesScreen
import com.zezzi.eventzezziapp.ui.meals.view.IngredientsCategoriesScreen
import com.zezzi.eventzezziapp.ui.meals.view.IngredientsCategoriesViewModel

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

        composable(route = "DishesCategoriesScreen/{mealName}") { backStackEntry ->
            val mealName = backStackEntry.arguments?.getString("mealName")
            if (mealName != null) {
                DishesCategoriesScreen(navController = navController, mealName = mealName)
            }
        }

        composable(route = "IngredientsCategoriesScreen/{dishId}") { backStackEntry ->
            val dishId = backStackEntry.arguments?.getString("dishId")
            if (dishId != null) {
                IngredientsCategoriesScreen(navController = navController, dishId = dishId)
            }
        }
    }
}

