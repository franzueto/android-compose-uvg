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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.data.networking.response.DishesResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishesCategoriesScreen(
    mealName: String,
    navController: NavController
) {
    val viewModel: DishesCategoriesViewModel = viewModel()

    val rememberedDishes: MutableState<List<DishesResponse>> =
        remember { mutableStateOf(emptyList<DishesResponse>()) }

    val isLoading: MutableState<Boolean> = remember { mutableStateOf(true) }

    LaunchedEffect(mealName) {
        try {
            val response = viewModel.getDishes(mealName)
            rememberedDishes.value = response?.meals.orEmpty()
            isLoading.value = false
            Log.d("DishesCategoriesScreen", "Data loaded successfully")
        } catch (e: Exception) {
            // Manejar errores si es necesario.
            isLoading.value = false
            Log.e("DishesCategoriesScreen", "Error loading data: $e")
        }
    }

    Scaffold(
        topBar = {
            AppBar(title = mealName, navController = navController)
        }
    ) {
        if (isLoading.value) {
            // Muestra el indicador de carga si isLoading es true
            LoadingScreen()
        } else {
            Column (modifier = Modifier.padding(it)){
                // Muestra la lista de botones si isLoading es false
                DishList(navController, rememberedDishes.value)
            }
        }
    }
}

@Composable
fun LoadingScreen() {
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
fun DishList(navController: NavController, dishes: List<DishesResponse>) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(207, 186, 240))
    ) {
        items(dishes) { dish ->
            Button(
                onClick = { navController.navigate("IngredientsCategoriesScreen/${dish.id}") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 25.dp)
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = dish.imageUrl1,
                        contentDescription = null,
                        modifier = Modifier.size(65.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = dish.name1,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}
