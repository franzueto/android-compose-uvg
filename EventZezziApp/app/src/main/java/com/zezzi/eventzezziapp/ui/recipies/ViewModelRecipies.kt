package com.zezzi.eventzezziapp.ui.recipies
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

class RecipesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    var recipesUiState by mutableStateOf(RecipesUiState(emptyList()))
        private set

    fun getRecipes(category: String) {
        recipesUiState = RecipesUiState(emptyList(), loading = true)
        viewModelScope.launch {
            recipesUiState = RecipesUiState(
                recipes = repository.getRecipes(category).recipes
            )
        }
    }
}
//Listo, solo revisar