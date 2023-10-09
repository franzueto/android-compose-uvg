//package com.zezzi.eventzezziapp.data.repository
import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.WithContext
import kotlinx.coroutines.Dispatchers
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
import MealsWebService


class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return withContext(Dispatchers.IO){
            try {
                val response = webService.getMeals()
                Result.success(response).getOrNull()
            } catch (e: Exception){
                printf("Error en el sistema")
                null
            }
        }
    }
}