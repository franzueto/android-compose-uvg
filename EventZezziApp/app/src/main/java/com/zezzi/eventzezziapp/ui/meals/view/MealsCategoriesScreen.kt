package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.data.networking.response.MealResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    val rememberedMeals: MutableState<List<MealResponse>> =
        remember { mutableStateOf(emptyList()) }

    LaunchedEffect(key1 = Unit) {
        try {
            val response = viewModel.getMeals()
            rememberedMeals.value = response?.categories.orEmpty()
        } catch (e: Exception) {

            e.printStackTrace()
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
                .background(color = Color(185, 125, 246))
                .verticalScroll(rememberScrollState()),
        ) {
            rememberedMeals.value.forEach { meal ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(20.dp),
                        ),
                    shape = RoundedCornerShape(20.dp),
                    color = Color(220, 186, 255)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {

                        Image(
                            painter = rememberAsyncImagePainter(model = meal.imageUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .size(85.dp)
                                .padding(2.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color(0, 0, 0, 0),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                        )
                        Column {
                            Text(
                                text = "Category Name",
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center

                            )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(3.dp)
                                    .padding(5.dp, 0.dp)
                                    .background(Color(0, 0, 0))
                            )
                            Text(
                                text = meal.name,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(3.dp)
                                    .padding(5.dp, 0.dp)
                                    .background(Color(0, 0, 0))
                            )
                            Text(
                                text = "Date: 10 Month 9 Day 2023",
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                fontSize = 14.sp,
                                textAlign = TextAlign.Left
                            )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(3.dp)
                                    .padding(5.dp, 0.dp)
                                    .background(Color(0, 0, 0))
                            )
                            Text(
                                text = "ID: ${meal.id}",
                                modifier = Modifier
                                    .padding(5.dp),
                                fontSize = 14.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}

