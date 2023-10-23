package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.DishCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.IngredientsCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DishWebService {
    private val api: DishApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(DishApi::class.java)
    }

    suspend fun getDishes(mealName: String): DishCategoriesResponse {
        return api.getDishes(mealName)
    }


}