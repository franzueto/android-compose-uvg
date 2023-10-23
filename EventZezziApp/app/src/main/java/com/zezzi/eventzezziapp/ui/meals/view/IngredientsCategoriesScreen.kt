package com.zezzi.eventzezziapp.ui.meals.view

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.data.networking.response.IngredientsResponse
import com.zezzi.eventzezziapp.navigation.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientsCategoriesScreen(dishId: String,navController: NavController) {
    val viewModel: IngredientsCategoriesViewModel =
        viewModel() // Debes crear un ViewModel adecuado para gestionar los platos de esta categoría

    // Recupera la lista de platos (dishes) para la categoría especificada
    val rememberedIngredients: MutableState<List<IngredientsResponse>> =
        remember { mutableStateOf(emptyList<IngredientsResponse>()) }

    val isLoading: MutableState<Boolean> = remember { mutableStateOf(true) }

    var recorrido = 1

    val context = LocalContext.current

    LaunchedEffect(dishId) {
        try {
            val response = viewModel.getIngredients(dishId)
            Log.d("IngredientsCategoriesScreen", "Response: $response")
            rememberedIngredients.value = response?.meals.orEmpty()
            isLoading.value = false
        } catch (e: Exception) {
            isLoading.value = false
            // Manejar errores si es necesario.
        }
    }
    Scaffold(
        topBar = {
            AppBar(
                title = dishId,
                navController = navController
            ) // Muestra el nombre de la categoría en la barra superior
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color(20, 33, 61))
                .verticalScroll(rememberScrollState()),

        ) {
            rememberedIngredients.value.forEach { ingredient ->

                // Categoría a la derecha
                Button(
                    onClick = {
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
                    val ingredients = listOf(
                        ingredient.ingredient1,
                        ingredient.ingredient2,
                        ingredient.ingredient3,
                        ingredient.ingredient4,
                        ingredient.ingredient5,
                        ingredient.ingredient6,
                        ingredient.ingredient7,
                        ingredient.ingredient8,
                        ingredient.ingredient9,
                        ingredient.ingredient10,
                        ingredient.ingredient11,
                        ingredient.ingredient12,
                        ingredient.ingredient13,
                        ingredient.ingredient14,
                        ingredient.ingredient15,
                        ingredient.ingredient16,
                        ingredient.ingredient17,
                        ingredient.ingredient18,
                        ingredient.ingredient19,
                        ingredient.ingredient20
                    )
                    Column(){
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .align(Alignment.CenterHorizontally), // Centra horizontalmente la imagen
                        ) {
                            AsyncImage(
                                model = ingredient.imageUrl,
                                contentDescription = null
                            )
                        }
                        Text(
                            text = "Ingredients:",
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            fontSize = 16.sp
                        )
                        //Mostrar todos los ingredientes
                        for (ingredient in ingredients) {
                            if (ingredient != "" && ingredient != null) {
                                Text(
                                    text = "$recorrido) $ingredient",
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                )
                            }
                            recorrido++
                        }
                        Text(
                            text = "Instructions:",
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            fontSize = 16.sp
                        )
                        Text(
                            text = ingredient.instructions,
                            textAlign = TextAlign.Justify,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                        Text(
                            text = "Link Youtube:",
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            fontSize = 16.sp
                        )
                        if (ingredient.youtube == ""){
                            Text(
                                text = "YouTube video not available",
                                textAlign = TextAlign.Center,
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                fontSize = 14.sp
                            )
                        }else{
                            Button(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ingredient.youtube))
                                    context.startActivity(intent)
                                },
                                modifier = Modifier
                                    .width(250.dp)
                                    .align(Alignment.CenterHorizontally),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(80, 0, 131, 255),
                                )
                            )
                            {
                                Text(
                                    text = "YouTube",
                                    fontSize = 16.sp,
                                    color = Color(199, 158, 226, 255),
                                )
                            }
                        }

                    }
                }

            }
        }

    }
}
