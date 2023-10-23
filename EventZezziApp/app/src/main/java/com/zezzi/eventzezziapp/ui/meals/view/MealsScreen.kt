package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.navigation.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsScreen(
    navController: NavController,
    category: String,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            AppBar(title = "Meals for $category", navController = navController)
        }
    ) {
        Text(
            text = "I am Meals screen for category: $category", modifier = Modifier.padding(it)
        )
    }
}