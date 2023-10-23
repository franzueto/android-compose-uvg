package com.zezzi.eventzezziapp.ui.food

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoryUiState
import kotlinx.coroutines.launch

class ViewMFood(private val repository: MealsRepository = MealsRepository()): ViewModel()  {
    var foodUiState by mutableStateOf(FoodUiState(emptyList()))
        private set
    fun getFood(name: String){
        foodState = StateFood(food = emptyList(),loading = true)
        viewModelScope.launch{
            val response = repository.getFood(name)
            Log.d("FoodViewModel", "Respuesta del repositorio: $response")
            foodState = StateFood(
                food = repository.getFood(name).foodInstruction
            )
        }
    }
}

//Arreglar la linea 22
