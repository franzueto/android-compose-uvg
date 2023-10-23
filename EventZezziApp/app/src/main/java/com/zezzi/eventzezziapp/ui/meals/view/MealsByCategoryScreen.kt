package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
    mealCategory: String) {
    LaunchedEffect(Unit) {
        viewModel.getMealsByCategory(mealCategory)
    }

    Scaffold(topBar = { AppBar(title = "Meals by $mealCategory", navController = navController) }) {
        Box(modifier = Modifier.fillMaxSize()){
            if (viewModel.isLoading.value){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }else{
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = it,
                    content = { items(viewModel.mealsByCategory.value) { meal -> MealCard(meal) } }
                )
            }
        }
    }

}

fun truncateText(text: String, maxLength: Int): String{
    return if (text.length > maxLength){
        text.substring(0, maxLength) + "..."
    }else{
        text
    }
}

@Composable
fun MealCard(meal: MealDetailResponse){
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(300.dp),
        shape = RoundedCornerShape(16.dp))
    {
        Column (
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = truncateText(meal.name, 22), fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.size(5.dp))
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = "Meal Image",
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.Crop)
        }
    }
}