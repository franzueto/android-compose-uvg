package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.WithContext
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            withContext(Dispatchers.IO) {
                val response = webService.getMeals().execute()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            }
        }catch (e: Exception){
            null
        }
    }
}