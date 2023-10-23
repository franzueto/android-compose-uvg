package com.zezzi.eventzezziapp.ui.recipes.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.navigation.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(
    navController: NavController,
    cat:String,
    viewModel: RecipeViewModel = viewModel()
) {
    if (viewModel.recipeState.recipe.isEmpty()){
        viewModel.getRecipe(cat)
    }

    Scaffold(
        topBar = {
            AppBar(
                title = "Ingredientes para $cat",
                navController = navController)
        }
    ) {
        LazyColumn(
            contentPadding = it,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(viewModel.recipeState.recipe) { index, recipe ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    AsyncImage(
                        model = recipe.imgeUrl,
                        contentDescription = "Image"
                    )
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                    Text(
                        text = recipe.name,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}