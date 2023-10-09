package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import androidx.lifecycle.viewModelScope
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

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
            AppBar(title = "RECETAS",
                navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(color = Color(207, 186, 240))
        ){
            rememberedMeals.value.forEach { meal ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    elevation = 4.dp,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(data = meal.imageUrl),
                            contentDescription = null,
                            modifier = Modifier.size(65.dp)
                        )
                        Text(
                            text = meal.name,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterVertically),
                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold )
                        )
                    }
                }
            }
        }
    }
}


