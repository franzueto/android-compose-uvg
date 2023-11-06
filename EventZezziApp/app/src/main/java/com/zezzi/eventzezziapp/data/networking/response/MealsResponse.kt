package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class MealsResponse(val meals: List<Meal>)

data class Meal(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
)
