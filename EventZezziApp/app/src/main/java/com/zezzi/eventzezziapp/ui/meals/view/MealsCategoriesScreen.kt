package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.data.networking.response.MealResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    LaunchedEffect(key1 = "Meals") {
        viewModel.getMeals()
    }

    Scaffold(
        topBar = {
            AppBar(title = "Categories", navController = navController)
        }
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            contentPadding = it){
            items(viewModel.categories.value){
                categories -> CardItems(categories = categories)
            }
        }
    }
}

@Composable
fun CardItems(categories: MealResponse){
    Card(shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier.padding(10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            AsyncImage(model = categories.imageUrl, contentDescription = "",Modifier.size(80.dp))
            Column {
                Text(text = "Category: ")
                Text(text = categories.name)
            }
        }
    }
}