package com.zezzi.eventzezziapp.data.networking



import android.util.Log
import com.zezzi.eventzezziapp.data.networking.response.RecipesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeWebService {
    private val api: RecipeApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(RecipeApi::class.java)
    }

    suspend fun getRecipe(cat: String): RecipesResponse {
        val response = api.getRecipe(cat)
        Log.d("Meals", "Id: $cat")
        return response

    }
}