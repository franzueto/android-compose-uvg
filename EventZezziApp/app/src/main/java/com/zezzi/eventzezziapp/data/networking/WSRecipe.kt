package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.RecipesR
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import android.util.Log

class RecipeWebService {
    private val api: RecipeAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(RecipeAPI::class.java)
    }

    suspend fun getRecipes(category: String): RecipesR {
        Log.d("MEALS", "ID: $category")
        val response = api.getRecipes(category)
        Log.d("RecipeWebService", "Respuesta del servicio de recetas para la categoría $category: $response")
        return response
    }
}