package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.material.Scaffold
import androidx.compose.material3.Divider
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.navigation.AppBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import coil.compose.AsyncImage
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import com.zezzi.eventzezziapp.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    val categoryUiState = viewModel.categoryUiState

    LaunchedEffect(categoryUiState.categories.isEmpty()) {
        if (categoryUiState.categories.isEmpty()) {
            viewModel.getMeals()
        }
    }

    Scaffold(
        topBar = {
            AppBar(title = "Meal Categories", navController = navController)
        }
    ) {
        if (categoryUiState.loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(10.dp),
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(12.dp)
            ) {
                items(categoryUiState.categories) { meal ->
                    CategoryCard(meal, navController)
                }
            }
        }
    }
}

@Composable
fun CategoryCard(meal: Meal, navController: NavController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .background(Color.White)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(120.dp, 160.dp),
                placeholder = painterResource(R.drawable.placeholder_image)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Category:",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 4.dp),
                    lineHeight = 20.sp
                )
                Text(
                    text = meal.name,
                    modifier = Modifier
                        .padding(top = 2.dp),
                    lineHeight = 20.sp
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 2.dp),
                    color = Color.LightGray,
                    thickness = 1.dp
                )
                Text(
                    text = "Description:",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 4.dp),
                    lineHeight = 20.sp
                )
                Text(
                    text = meal.description,
                    modifier = Modifier
                        .padding(top = 2.dp),
                    lineHeight = 18.sp
                )
            }
        }
    }
}

//LISTO!!