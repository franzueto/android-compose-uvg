package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.RecipesWebService
import com.zezzi.eventzezziapp.data.networking.response.RResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipesRepository(private val webService: RecipesWebService = RecipesWebService()) {
    suspend fun getRecipes(cat:String): RResponse{
        return withContext(Dispatchers.IO){
            webService.getRecipe(cat)
        }
    }
}