package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.RecipesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("filter.php")
    suspend fun getRecipe(@Query("c") cat:String):RecipesResponse
}