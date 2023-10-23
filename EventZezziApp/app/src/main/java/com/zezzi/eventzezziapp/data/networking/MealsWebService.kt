package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import retrofit2.Retrofit
import com.zezzi.eventzezziapp.data.networking.response.RecipesR
import retrofit2.converter.gson.GsonConverterFactory
import com.zezzi.eventzezziapp.data.networking.response.FoodResponseComplete
import android.util.Log
import com.zezzi.eventzezziapp.data.networking.response.FoodResponse



class MealsWebService {

    private val api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getRecipes(category: String): RecipesR {
        return api.getRecipes(category)
    }

    suspend fun getFood(name: String): FoodResponseComplete {
        val response = api.getFood(name)
        Log.d("FoodViewModel", "Respuesta del repositorio: $response")
        return api.getFood(name)
    }
}