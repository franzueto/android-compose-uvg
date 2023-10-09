package com.zezzi.eventzezziapp.ui.meals.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import coil.compose.rememberAsyncImagePainter
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.navigation.AppBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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
            null
        }
    }

    Scaffold(
        topBar = {
            AppBar(title = "Recipies", navController = navController)
        }
    ) {
        MealList(meals = rememberedMeals)

    }

}

@Composable
fun MealList(meals: MutableState<List<MealResponse>>) {
    val mealList = meals.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .padding(10.dp)
    ) {
        mealList.forEach { meal ->
            MealCard(meal = meal)
        }
    }
}

@Composable
fun MealCard(meal: MealResponse) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(10.dp),
            ),
        shape = RoundedCornerShape(10.dp),
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MealImage(imageUrl = meal.imageUrl)
            MealDetails(meal = meal)
        }
    }
}

@Composable
fun MealImage(imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(model = imageUrl),
        contentDescription = null,
        modifier = Modifier.size(95.dp)
    )
}

@Composable
fun MealDetails(meal: MealResponse) {
    Column(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Category Name",
            modifier = Modifier.padding(top = 2.dp),
            style = TextStyle(fontSize = 15.sp)
        )

        Text(
            text = meal.name,
            modifier = Modifier.padding(top = 2.dp),
            style = TextStyle(fontSize = 15.sp)
        )

        Divider(color = Color.Gray)

        Text(
            text = "Date 10 Month 8 day",
            modifier = Modifier.padding(top = 2.dp),
            style = TextStyle(fontSize = 15.sp)
        )
    }

}
