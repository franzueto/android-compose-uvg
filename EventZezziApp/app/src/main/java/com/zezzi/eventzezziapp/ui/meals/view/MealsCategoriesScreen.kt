package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    // Utiliza una variable para almacenar el resultado de la llamada
    var rememberedMeals: MealsCategoriesResponse? by remember { mutableStateOf(null) }

    // Utiliza un bloque de coroutines para realizar la llamada
    LaunchedEffect(key1 = Unit) {
        val response = viewModel.getMeals()
        rememberedMeals = response
    }

    Scaffold(
        topBar = {
            AppBar(title = "Recepies", navController = navController)
        }
    ) {
        LazyColumn(contentPadding = it) {
            items(rememberedMeals?.categories.orEmpty()) { meal ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = meal.name)
                }
            }
        }
    }
}


