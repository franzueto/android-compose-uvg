package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.navigation.AppBar
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.layout.Modifier
import androidx.compose.ui.layout.weight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel())
{
    LaunchedEffect(Unit) {
        viewModel.getMeals()
    }

    Scaffold(topBar = { AppBar(title = "Categories", navController = navController) })
    {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = it,
            content = { items(viewModel.meals.value) { meal -> CategoryCard(meal) } }
        )
    }
}

@Composable
fun CategoryCard(meal: MealResponse) {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(250.dp)
            .clickable { showDialog = true },
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
                .fontFamily(FontFamily.SansSerif),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = meal.name,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = "Category Image",
                modifier = Modifier.size(120.dp)
            )
        }
    }

    if (showDialog) {
        ShowDescriptionDialog(meal) {
            showDialog = false
        }
    }
}




@Composable
fun ShowDescriptionDialog(meal: MealResponse, onClose: () -> Unit) {
    AlertDialog(
        onDismissRequest = onClose,
        title = { Text(text = meal.name, fontSize = 24.sp) },
        text = { Text(text = meal.description, fontSize = 15.sp) },
        confirmButton = {
            TextButton(onClick = onClose) {
                Text("Ok")
            }
        },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.border(2.dp, Color.Gray)
    )
}


