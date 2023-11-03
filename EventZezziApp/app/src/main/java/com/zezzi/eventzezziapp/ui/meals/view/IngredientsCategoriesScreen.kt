package com.zezzi.eventzezziapp.ui.meals.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.data.networking.response.DishesResponse
import com.zezzi.eventzezziapp.data.networking.response.IngredientsResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientsCategoriesScreen(
    dishId: String,
    navController: NavController
) {
    val viewModel: IngredientsCategoriesViewModel = viewModel()

    val rememberedIngredients: MutableState<List<IngredientsResponse>> =
        remember { mutableStateOf(emptyList<IngredientsResponse>()) }

    val isLoading: MutableState<Boolean> = remember { mutableStateOf(true) }

    LaunchedEffect(dishId) {
        try {
            val response = viewModel.getIngredients(dishId)
            rememberedIngredients.value = response?.meals.orEmpty()
            isLoading.value = false
            Log.d("IngredientsCategoriesScreen", "Data loaded successfully")
        } catch (e: Exception) {
            // Manejar errores si es necesario.
            isLoading.value = false
            Log.e("IngredientsCategoriesScreen", "Error loading data: $e")
        }
    }

    Scaffold(
        topBar = {
            AppBar(title = dishId, navController = navController)
        }
    ) {
        if (isLoading.value) {
            // Muestra el indicador de carga si isLoading es true
            LoadingScreen2()
        } else {
            Column (modifier = Modifier.padding(it)){
                // Muestra la lista de botones si isLoading es false
                IngredientsList(rememberedIngredients.value)
            }
        }
    }
}

@Composable
fun LoadingScreen2() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(207, 186, 240)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun IngredientsList(rememberedIngredients: List<IngredientsResponse>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0.81f, 0.73f, 0.94f))
    ) {
        items(rememberedIngredients) { ingredient ->
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
            Column {
                AsyncImage(
                    model = ingredient.imageUrl3,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .align(Alignment.CenterHorizontally)
                )
                Text(text = "INGREDIENTES:",
                    style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                )
                Text(
                    text = ingredients.filter { it.isNotEmpty() }.joinToString(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
                Text(text = "INSTRUCCIONES:",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                )
                Text(
                    text = ingredient.instructions,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

