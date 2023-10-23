package com.zezzi.eventzezziapp.ui.meals.view

import retrofit2.http.GET
import retrofit2.http.Query

interface DishesApi {
    @GET("meals.php")
    suspend fun getDishesByCategory(@Query("category") category: String): List<Dish>
}
