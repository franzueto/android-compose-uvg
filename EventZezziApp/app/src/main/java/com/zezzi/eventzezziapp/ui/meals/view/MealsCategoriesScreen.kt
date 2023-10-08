package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.navigation.AppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    val rememberedMeals: MutableState<List<MealResponse>> =
        remember { mutableStateOf(emptyList<MealResponse>()) }

    LaunchedEffect(key1 = Unit) {
        try {
            val response = viewModel.getMeals()
            rememberedMeals.value = response?.categories.orEmpty()
        } catch (e: Exception) {
            // Manejar errores si es necesario.
        }
    }

    Scaffold(
        topBar = {
            AppBar(title = "Recipies", navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color(20, 33, 61)),

        ) {
            rememberedMeals.value.forEach { meal ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(20.dp),
                        ),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp), // Espaciado entre elementos
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Imagen a la izquierda
                        Image(
                            painter = rememberImagePainter(data = meal.imageUrl),
                            contentDescription = null, // Agrega descripción apropiada
                            modifier = Modifier
                                .size(85.dp) // Tamaño de la imagen
                        )
                        Column(

                        ) {
                            Text(
                                text = "Category Name",
                                modifier = Modifier
                                    .padding(start = 16.dp), // Espaciado entre imagen y texto
                                style = TextStyle(fontSize = 16.sp) // Tamaño de texto apropiado
                            )

                            // Categoría a la derecha
                            Text(

                                text = meal.name,
                                modifier = Modifier
                                    .padding(start = 16.dp), // Espaciado entre imagen y texto
                                style = TextStyle(fontSize = 16.sp) // Tamaño de texto apropiado
                            )
                            Divider(
                                color = Color.Gray,
                            )
                            Text(
                                text = "Date 10 Month 8 day",
                                modifier = Modifier
                                    .padding(start = 16.dp), // Espaciado entre imagen y texto
                                style = TextStyle(fontSize = 16.sp) // Tamaño de texto apropiado
                            )
                        }
                    }
                }
            }
        }
    }
}

