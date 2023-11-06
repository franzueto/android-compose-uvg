package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.navigation.NavigationState
import com.zezzi.eventzezziapp.ui.common.CircularLoadingSpinner

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    if (viewModel.categoryUiState.categories.isEmpty()) {
        viewModel.getMeals()
    }

    Scaffold(
        topBar = {
            AppBar(title = "Categories", navController = navController)
        }
    ) {
        if (viewModel.categoryUiState.loading) {
            CircularLoadingSpinner()
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = it,
            ) {
                items(viewModel.categoryUiState.categories) { meal ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        elevation = 2.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        onClick = {
                            navController.navigate("${NavigationState.Meals.route}/${meal.name}")
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = meal.name,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            AsyncImage(
                                model = meal.imageUrl,
                                contentDescription = null,
                            )
                        }
                    }
                }
            }
        }
    }
}
