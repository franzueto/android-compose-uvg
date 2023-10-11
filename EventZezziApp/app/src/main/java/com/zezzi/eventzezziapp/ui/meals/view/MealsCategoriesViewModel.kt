package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kotlinx.coroutines.runBlocking
import coil.compose.AsyncImage
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking



class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    //fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
    //var categories: MutableState<MealsCategoriUiState> by mutableStateOf(MealsCategoriUiState())
    //    private set
    //MealsCategoriesResponse
    //fun getMeals() {
    //    viewModelScope.launch {
    //        categories.value = MealsCategoriUiState(
    //            categories = repository.getMeals().categories
    //        )
    //    }
    //------------------------------------------------------------------------------
    suspend fun getMeals(): MealsCategoriesResponse? {
        return repository.getMeals()
    }
    //------------------------------------------------------------------------------

}