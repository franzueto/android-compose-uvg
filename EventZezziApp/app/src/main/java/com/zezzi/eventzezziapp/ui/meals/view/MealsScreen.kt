package com.zezzi.eventzezziapp.ui.meals.view

import android.annotation.SuppressLint
import androidx.compose.material.ExperimentalMaterialApi

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zezzi.eventzezziapp.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MealsScreen(
    navController: NavController,
    category: String,
    modifier: Modifier = Modifier,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            AppBar(title = "Meals for $category", navController = navController)
        }
    ) {

            var scrollState = rememberScrollState()
            Column(
                modifier = modifier
                    .verticalScroll(state = scrollState)
            ) {
                androidx.compose.material3.Text(
                    text = "",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(20.dp),
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),

                    )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp) // Ajusta la altura según tus necesidades
                ) {

                    Image(
                        painter = painterResource(R.drawable.bg_compose_background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Título debajo de la imagen
                androidx.compose.material3.Text(
                    text = "DESAYUNOS",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.Start),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    color = Color.Gray // Cambia el color del texto según tus preferencias
                )

                // Dos imágenes a la par de la otra
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.image1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(140.dp)
                            .width(170.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.image2),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(140.dp)
                            .width(170.dp)
                    )
                }

                // Otro título con dos imágenes debajo
                androidx.compose.material3.Text(
                    text = "ALMUERZOS",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.Start),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    color = Color.Gray // Cambia el color del texto según tus preferencias
                )

                // Dos imágenes a la par de la otra
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.image3),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(140.dp)
                            .width(170.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.image4),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(140.dp)
                            .width(170.dp)
                    )
                }
                // Título debajo de la imagen
                androidx.compose.material3.Text(
                    text = "CENAS",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.Start),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    color = Color.Gray // Cambia el color del texto según tus preferencias
                )

                // Dos imágenes a la par de la otra
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.image5),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(140.dp)
                            .width(170.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.image6),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(140.dp)
                            .width(170.dp)
                    )
                }
            }
        }

}
