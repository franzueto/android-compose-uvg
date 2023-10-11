package com.zezzi.eventzezziapp.ui.meals.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            AppBar(title = "Recetario", navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color(233, 30, 99, 255))
                .verticalScroll(rememberScrollState()),
        ) {

            rememberedMeals.value.forEach { platillo ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .shadow(
                            elevation = 15.dp,
                            shape = RoundedCornerShape(20.dp),
                        ),
                    shape = RoundedCornerShape(20.dp),
                    color = Color(63, 81, 181, 255)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {

                        Image(
                            painter = rememberAsyncImagePainter(model = platillo.imageUrl),
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
                                text = "Nombre de platillo",
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center

                            )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(5.dp)
                                    .padding(5.dp, 0.dp)
                                    .background(Color(0, 0, 0))
                            )
                            Text(
                                text = platillo.name,
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
                                    .height(5.dp)
                                    .padding(5.dp, 0.dp)
                                    .background(Color(0, 0, 0))
                            )
                            Text(
                                text = "Fecha: 10 de Octubre del año 2023",
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                fontSize = 14.sp,
                                textAlign = TextAlign.Left
                            )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(5.dp)
                                    .padding(5.dp, 0.dp)
                                    .background(Color(0, 0, 0))
                            )
                            Text(
                                text = "ID de imagen: ${platillo.id}",
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

