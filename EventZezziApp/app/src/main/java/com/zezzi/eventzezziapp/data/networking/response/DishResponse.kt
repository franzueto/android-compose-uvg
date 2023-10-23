package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class DishCategoriesResponse(@SerializedName("meals") val filter: List<DishResponse>)

data class DishResponse(
    @SerializedName("strMeal") val name1: String,
    @SerializedName("strMealThumb") val imageUrl2: String,
    @SerializedName("idMeal") val description3: String,
)