package com.zezzi.eventzezziapp.ui.recipies

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: RecipeRepository = RecipeRepository()): ViewModel() {
    var recipeState by mutableStateOf(RecipeState(emptyList()))
        private set
    fun getRecipe(cat: String) {
        recipeState = RecipeState(emptyList())
        viewModelScope.launch {
            val recipeResponse = repository.getRecipes(cat)
            recipeState = RecipeState(
                repository.getRecipes(cat).categories
            )
        }
    }
}