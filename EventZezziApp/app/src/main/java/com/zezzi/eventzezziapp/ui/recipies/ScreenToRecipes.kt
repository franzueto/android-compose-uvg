package com.zezzi.eventzezziapp.ui.recipies

import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoriesViewModel
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import com.zezzi.eventzezziapp.navigation.NavigationState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import com.zezzi.eventzezziapp.navigation.AppBar
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.material.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zezzi.eventzezziapp.R
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MealsScreen(
    navController: NavController,
    category: String,
    viewModel: RecipesViewModel = viewModel()
) {
    val recipesUiState = viewModel.recipesUiState

    LaunchedEffect(category) {
        if (recipesUiState.recipes.isEmpty()) {
            viewModel.getRecipes(category)
        }
    }

    Scaffold(
        topBar = {
            AppBar(title = "Meals for $category", navController = navController)
        }
    ) {
        if (recipesUiState.loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(10.dp),
                modifier = Modifier
                    .background(Color.Gray)
                    .padding(10.dp)
            ) {
                items(recipesUiState.recipes) { recipe ->
                    RecipeCard(recipe = recipe, navController = navController)
                }
            }
        }
    }
}

@Composable
fun RecipeCard(recipe: Recipe, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Gray),
        onClick = {
            navController.navigate("${NavigationState.FoodScreen.route}/${recipe.meal}")
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = recipe.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(110.dp, 150.dp)
                    .padding(end = 10.dp),
                placeholder = painterResource(R.drawable.placeholderimage)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(1.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = recipe.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = recipe.meal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                )
            }
        }
    }
}

//LISTO, PERO REVISAR IGUALMENTE