package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.navigation.routeWithArgument

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel())
{

    LaunchedEffect(Unit) {
        viewModel.getMeals()
    }

    Scaffold(topBar = { AppBar(title = "Categories", navController = navController) })
    {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = it,
            content = { items(viewModel.meals.value) { meal -> CategoryCard(navController, meal) } }
        )
    }
}

@Composable
fun CategoryCard(navController: NavController, meal: MealResponse) {

    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(250.dp)
            .clickable {
                       navController.navigate(routeWithArgument(meal.name))
                },
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = "Category Image",
                modifier = Modifier.size(120.dp)
            )
            Text(text = meal.name, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text(text = "${meal.description.take(50)}...", fontSize = 15.sp)
        }
    }
}