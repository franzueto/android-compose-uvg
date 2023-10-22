package com.zezzi.eventzezziapp.ui.meals.view

//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material3.Divider
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.navigation.AppBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import coil.compose.rememberImagePainter
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth
//import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.navigation.NavigationState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import coil.compose.AsyncImage
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import com.zezzi.eventzezziapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {

    val rememberedMeals: MutableState<List<MealResponse>> =
        remember { mutableStateOf(emptyList<MealResponse>()) }

    LaunchedEffect(key1 = Unit){
        try {
            val response = viewModel.getMeals()
            rememberedMeals.value = response?.categories.orEmpty()
        } catch (e: Exception) {
        }
    }

    Scaffold(
        topBar = {
            AppBar(title = "Categories", navController = navController)
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color(44, 4, 54))
        ) {
            items(rememberedMeals.value) { meal ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberImagePainter(data = meal.imageUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .size(85.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Category Name",
                                style = TextStyle(fontSize = 16.sp),
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = meal.name,
                                style = TextStyle(fontSize = 16.sp),
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Divider(
                                color = Color.Gray,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = "Date 10 Month 8 day",
                                style = TextStyle(fontSize = 16.sp)
                            )
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color(44, 4, 54))
        ) {
            rememberedMeals.value.forEach { meal ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .shadow(
                            elevation = 7.dp,
                            shape = RoundedCornerShape(14.dp)
                        ),
                    shape = RoundedCornerShape(14.dp),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberImagePainter(data = meal.imageUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(
                            modifier = Modifier.weight(0f)
                        ) {
                            Text(
                                text = "Category Name",
                                style = TextStyle(fontSize = 6.sp),
                                modifier = Modifier.padding(bottom = 2.dp)
                            )
                            Text(
                                text = meal.name,
                                style = TextStyle(fontSize = 6.sp),
                                modifier = Modifier.padding(bottom = 2.dp)
                            )
                            Divider(
                                color = Color.Gray,
                                modifier = Modifier.padding(bottom = 2.dp)
                            )
                            Text(
                                text = "Date 5 Month 5 day",
                                style = TextStyle(fontSize = 6.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}
