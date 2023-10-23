package com.zezzi.eventzezziapp.ui.meals.view

import androidx.activity.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import com.zezzi.eventzezziapp.navigation.NavigationState
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import kotlinx.coroutines.runBlocking
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val rememberedMeals: MutableState<List<MealResponse>> =
        remember { mutableStateOf(emptyList<MealResponse>()) }
    if (viewModel.meals.cat.isEmpty()){
        viewModel.getMeals()
    }
    Scaffold(
        topBar = {
            AppBar(title = "Categories", navController = navController)
        }
    ) {
        LazyColumn(contentPadding = it) {
            items(viewModel.meals.cat) { meal ->
                ElevatedButton(
                    onClick = { navController.navigate("${NavigationState.RecipeScreen.route}/${meal.name}") },
                    modifier = Modifier
                        .padding(2.dp)
                ) {

                    Row {
                        AsyncImage(
                            model = meal.imageUrl,
                            contentDescription = meal.description,
                            modifier = Modifier.padding(10.dp)
                        )
                        Column(
                            modifier = Modifier.weight(3f),
                            verticalArrangement = Arrangement.Center
                        ){
                            Text(
                                text = "Category Name",
                                modifier = Modifier.padding(7.dp),
                                color = Color.Black,

                                )
                            Text(
                                text = meal.name,
                                modifier = Modifier.padding(7.dp),
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier
                                .background(Color.Gray)
                                .height(1.dp))
                            Text(text = "aa")
                        }
                    }
                }
            }
        }
    }
}