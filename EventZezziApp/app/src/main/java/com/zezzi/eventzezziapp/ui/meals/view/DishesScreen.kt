package com.zezzi.eventzezziapp.ui.meals.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.navigation.AppBar

@JvmOverloads
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishesScreen(
    navController: NavController,
    category: String,
    viewModel: DishesViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val dishUiState by viewModel.dishUiState

    LaunchedEffect(category) {
        viewModel.getDishesByCategory(category)
    }

    Scaffold(
        topBar = {
            AppBar(title = "Dishes for $category", navController = navController)
        }
    ) {
        if (dishUiState.loading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        } else {
            LazyColumn {
                items(dishUiState.dishes) { dish ->
                    // Render each dish item here
                }
            }
        }
    }
}
