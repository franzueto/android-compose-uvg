package com.zezzi.eventzezziapp.data.networking.response


import com.google.gson.annotations.SerializedName

data class MealsAnswer(val categories: List<MealsAnswer>)

data class MealAnswer(
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)