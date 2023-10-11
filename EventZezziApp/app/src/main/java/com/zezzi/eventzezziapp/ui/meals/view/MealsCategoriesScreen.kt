
package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.navigation.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    val rememberedMeals: MutableState<List<MealResponse>> =
        remember { mutableStateOf(emptyList()) }

    LaunchedEffect(Unit) {
        viewModel.getMeals()
    }

    Scaffold(
        topBar = {
            AppBar(title = "Categories", navController = navController)
        }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = it,
            content = { items(viewModel.meals.value) { meal -> ShowedCard(meal) } }
        )
    }
}

@Composable
fun ShowedCard(meal: MealResponse) {
    Card() {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = meal.name, fontSize = 35.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "${meal.description.take(50)}...", fontSize = 20.sp)
        }
    }
}
