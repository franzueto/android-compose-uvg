package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.navigation.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()){

    LaunchedEffect(Unit) {
        viewModel.getMeals()
    }

    Scaffold(topBar = { AppBar(title = "Categories", navController = navController) })
    {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = it,
            content = {items(viewModel.meals.value){meal -> CategoryCard(meal)}})
    }
}

@Composable
fun CategoryCard(meal: MealResponse){
    Card (elevation = 8.dp
        , modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { /* Navigation Here */ })
    {
        Column(modifier = Modifier.padding(16.dp))
        {
            AsyncImage(model = meal.imageUrl, contentDescription = "Category Image")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = meal.name)
            Text(text = meal.description)
        }
    }
}