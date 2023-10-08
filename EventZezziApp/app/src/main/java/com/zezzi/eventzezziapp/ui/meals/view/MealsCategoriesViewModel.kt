package com.zezzi.eventzezziapp.ui.meals.view

import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.runBlocking

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals() {
        println("1")
        runBlocking {
            println(repository.getMeals ())
        }
    }
}