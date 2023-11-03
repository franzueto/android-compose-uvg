package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class DishesCategoriesResponse(val meals: List<DishesResponse>)

data class DishesResponse(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name1: String,
    @SerializedName("strMealThumb") val imageUrl1: String
)
