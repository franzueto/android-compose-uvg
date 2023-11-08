package com.zezzi.eventzezziapp.data.repository
import com.zezzi.eventzezziapp.data.networking.RecipeWebService
import com.zezzi.eventzezziapp.data.networking.response.RecipesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepository(private val webService: RecipeWebService = RecipeWebService()) {
    suspend fun getRecipes(cat:String): RecipesResponse{
        return withContext(Dispatchers.IO){
            webService.getRecipe(cat)}
    }
}