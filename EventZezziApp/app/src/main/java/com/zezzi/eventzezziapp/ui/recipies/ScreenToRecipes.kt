package com.zezzi.eventzezziapp.ui.recipies

import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoriesViewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.padding
import com.zezzi.eventzezziapp.navigation.AppBar
import androidx.compose.runtime.Composable
import androidx.compose.material.Scaffold
import androidx.navigation.NavController
import androidx.compose.material.Text
import androidx.compose.ui.Modifier


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
            text = "Screen for food category: $category", modifier = Modifier.padding(it),
            modifier = Modifier.padding(16.dp)
        )
    }
}