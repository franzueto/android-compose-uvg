package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.DishesCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse

    @GET("filter.php")
    suspend fun getDishes(@Query("c") mealName: String): DishesCategoriesResponse

    @GET("lookup.php")
    suspend fun getIngredients(@Query("i") dishId:String): IngredientsCategoriesResponse
}


