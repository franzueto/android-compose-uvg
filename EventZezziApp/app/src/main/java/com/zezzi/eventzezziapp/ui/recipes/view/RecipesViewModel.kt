package com.zezzi.eventzezziapp.ui.recipes.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.RecipesRepository
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: RecipesRepository = RecipesRepository()): ViewModel() {
    var recipeState by mutableStateOf(RecipesState(emptyList()))
        private set

    fun getRecipe(cat: String) {
        recipeState = RecipesState(emptyList())
        viewModelScope.launch {
            val recipeResponse = repository.getRecipes(cat)
            recipeState = RecipesState(
                repository.getRecipes(cat).categories
            )
        }
    }
}