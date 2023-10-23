package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IngredientsApi {
    @GET("lookup.php")
    suspend fun getIngredients(@Query("i") dishId:String): IngredientsCategoriesResponse
}