package com.zezzi.eventzezziapp.ui.meals.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.data.networking.response.DishResponse
import com.zezzi.eventzezziapp.navigation.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishesCategoriesScreen(mealName: String,navController: NavController) {
    val viewModel: DishesCategoriesViewModel =
        viewModel() // Debes crear un ViewModel adecuado para gestionar los platos de esta categoría

    // Recupera la lista de platos (dishes) para la categoría especificada
    val rememberedDishes: MutableState<List<DishResponse>> =
        remember { mutableStateOf(emptyList<DishResponse>()) }

    val isLoading: MutableState<Boolean> = remember { mutableStateOf(true) }

    LaunchedEffect(mealName) {
        try {
            val response = viewModel.getDishes(mealName)
            Log.d("DishesCategoriesScreen", "Response: $response")
            rememberedDishes.value = response?.filter.orEmpty()
            isLoading.value = false
        } catch (e: Exception) {
            isLoading.value = false
            // Manejar errores si es necesario.
        }
    }

    Scaffold(
        topBar = {
            AppBar(
                title = mealName,
                navController = navController
            ) // Muestra el nombre de la categoría en la barra superior
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color(20, 33, 61))
        ) {
            if (isLoading.value) {
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

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = it,
                ) {
                    items(rememberedDishes.value) { dish ->
                        Button(
                            onClick = {
                                navController.navigate("IngredientsCategoriesScreen/${dish.description3}")
                                // Aquí puedes poner la acción que se ejecutará cuando se haga clic en el botón.
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .shadow(
                                    elevation = 10.dp,
                                    shape = RoundedCornerShape(20.dp),
                                ),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp), // Espaciado entre elementos y
                            ) {

                                // Imagen a la izquierda
                                AsyncImage(
                                    model = dish.imageUrl2,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(100.dp)
                                        .padding(end = 16.dp),
                                )

                                // Categoría a la derecha
                                Text(
                                    text = dish.name1,
                                    modifier = Modifier
                                        .padding(start = 16.dp), // Espaciado entre imagen y texto
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    ), // Tamaño de texto apropiado
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis // Tamaño de texto apropiado

                                )

                            }
                        }

                    }
                }
            }
        }
    }
}


