package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsResponse
import retrofit2.http.GET

interface MealsApi {
    @GET("categories.php")
    suspend fun getCategories(): MealsCategoriesResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(): MealsResponse
}