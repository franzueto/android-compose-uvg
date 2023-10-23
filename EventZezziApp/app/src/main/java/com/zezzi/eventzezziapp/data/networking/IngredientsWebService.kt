package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IngredientsWebService {
    private val api: IngredientsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(IngredientsApi::class.java)
    }
    suspend fun getIngredients(dishId: String): IngredientsCategoriesResponse {
        return api.getIngredients(dishId)
    }
}