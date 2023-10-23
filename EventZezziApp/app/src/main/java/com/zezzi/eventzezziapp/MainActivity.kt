package com.zezzi.eventzezziapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zezzi.eventzezziapp.navigation.Navigation
import com.zezzi.eventzezziapp.navigation.NavigationState
import com.zezzi.eventzezziapp.ui.meals.view.DishesScreen
import com.zezzi.eventzezziapp.ui.theme.EventZezziAppTheme
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventZezziAppTheme {
                // Crear un NavController para gestionar la navegación
                val navController = rememberNavController()

                // Configurar el NavHost con las rutas y pantallas correspondientes
                NavHost(navController = navController, startDestination = NavigationState.Categories.route) {
                    composable(route = NavigationState.Categories.route) {
                        // Pantalla de categorías
                        Navigation(navController = navController)
                    }
                    composable(
                        route = "${NavigationState.Meals.route}/{category}",
                        arguments = listOf(navArgument("category") { type = NavType.StringType })
                    ) { backstackEntry ->
                        // Pantalla de platillos por categoría
                        val category = backstackEntry.arguments?.getString("category") ?: ""
                        DishesScreen(navController, category)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MealsAppPreview() {
    EventZezziAppTheme {
        Navigation(navController = rememberNavController())
    }
}
