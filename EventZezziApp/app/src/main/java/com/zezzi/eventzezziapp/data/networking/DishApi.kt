package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.DishCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DishApi {
    @GET("filter.php")
    suspend fun getDishes(@Query("c") mealName: String): DishCategoriesResponse


}