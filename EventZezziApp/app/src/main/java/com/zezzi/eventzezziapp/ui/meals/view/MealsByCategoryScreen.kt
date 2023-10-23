package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MealsByCategoryScreen(
    viewModel: MealsCategoriesViewModel = viewModel(),
    mealCategory: String)
{
    LaunchedEffect(Unit) {
            viewModel.getMealsByCategory(mealCategory)
    }

    Column(modifier = Modifier.padding(1.dp)) {
            for (meal in viewModel.mealsByCategory.value){
                Text(text = meal.name)
            }
        }
}