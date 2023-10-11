package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kotlinx.coroutines.runBlocking
import coil.compose.AsyncImage

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.data.networking.response.MealResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {

    //val rememberedMeals by viewModel.categories.coll
    val rememberedMeals: MutableState<List<MealResponse>> =
        remember { mutableStateOf(emptyList<MealResponse>()) }

    //rememberedMeals.value = viewModel.getMeals().categories//.orEmpty() //min 24:26

    runBlocking{
        val categories = viewModel.getMeals()?.categories
        rememberedMeals.value = categories.orEmpty()
    }

    Scaffold(
        topBar = {
            AppBar(title = "Categories", navController = navController)
        }
    ) {
        LazyColumn(contentPadding = it) {
            items(rememberedMeals.value) { meal ->
                Text(text = meal.name)
                Box(
                    modifier = Modifier.padding(2.dp)
                ){
                    Row(){
                        AsyncImage(
                            model = meal.imageUrl,
                            contentDescription = meal.description
                        )
                        Column(
                            modifier = Modifier.padding(2.dp)
                        ){
                            Text(
                            text = meal.name,
                            modifier = Modifier.padding(2.dp),
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}