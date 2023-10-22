package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.response.RecipesResponse
import com.zezzi.eventzezziapp.data.networking.RecipeWebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
//import java.lang.Exception

class RecipeRepository(private val webService: RecipeWebService = RecipeWebService())  {
    suspend fun getRecipes(category: String): RecipesResponse {
        return withContext(Dispatchers.IO){
            webService.getRecipes(category)
        }
    }
}