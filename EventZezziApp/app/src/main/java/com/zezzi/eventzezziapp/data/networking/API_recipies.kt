package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.RecipesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeAPI {
    @GET("filter.php")
    suspend fun getRecipes(@Query("c") category: String): RecipesResponse
}