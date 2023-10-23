package com.zezzi.eventzezziapp.ui.food

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.R
import com.zezzi.eventzezziapp.navigation.AppBar
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun FoodScreen(
    navController: NavController,
    name: String,
    viewModel: ViewModelFood = viewModel()
) {
    if (viewModel.StateFood.food.isEmpty()) {
        viewModel.getFood(name)
    }

    Scaffold(
        topBar = {
            AppBar(title = "Recipe for $name", navController = navController)
        }
    ) {
        if (viewModel.StateFood.loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        } else {
            val food = viewModel.foodUiState.food.getOrNull(0)

            LazyColumn(
                contentPadding = it,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ) {
                food?.let { f ->
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = f.name,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                    }

                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(165.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(
                                model = f.imagenUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .width(140.dp)
                                    .height(140.dp)
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column {
                                Text(
                                    text = "Ingredients:",
                                    modifier = Modifier
                                        .height(40.dp),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                val ingredients = listOf(
                                    f.ingred1, f.ingred2, f.ingred3, f.ingred4, f.ingred5,
                                    f.ingred6, f.ingred7, f.ingred8, f.ingred9, f.ingred10
                                )
                                ingredients.forEach { ingredient ->
                                    ingredient?.let { Text(text = it) }
                                }
                            }

                            Column {
                                Text(
                                    text = "Measures:",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .padding(top = 10.dp),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                val parts = listOf(
                                    f.parte1, f.parte2, f.parte3, f.parte4, f.parte5,
                                    f.parte6, f.parte7, f.parte8, f.parte9, f.parte10
                                )
                                parts.forEach { part ->
                                    part?.let { Text(text = part) }
                                }
                            }
                        }
                    }

                    item {
                        Text(
                            text = "Instructions",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(top = 10.dp),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }

                    item {
                        f.instrucs?.let { instructions ->
                            Text(
                                text = instructions,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(30.dp)
                                    .padding(top = 5.dp),
                                fontSize = 11.sp,
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }
        }
    }
}