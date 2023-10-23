package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.data.networking.response.MealDetailResponse
import com.zezzi.eventzezziapp.navigation.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsByCategoryScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel(),
    mealCategory: String)
{
    LaunchedEffect(Unit) {
        viewModel.getMealsByCategory(mealCategory)
    }

    Scaffold (topBar = { AppBar(title = "Meals by $mealCategory", navController = navController)}){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = it,
            content = {items(viewModel.mealsByCategory.value) {meal -> MealCard(meal)} })
    }
}

@Composable
fun MealCard(meal: MealDetailResponse){
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(250.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column (
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = meal.name, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = "Meal Image",
                modifier = Modifier.size(120.dp))
        }
    }
}