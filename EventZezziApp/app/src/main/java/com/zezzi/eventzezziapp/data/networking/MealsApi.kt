package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.zezzi.eventzezziapp.data.networking.response.RecipesResponse

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse
}