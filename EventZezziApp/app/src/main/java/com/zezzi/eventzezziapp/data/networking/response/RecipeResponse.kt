package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class RResponse(
    @SerializedName("meals") val categories:List<RecipeResponse>
)
data class RecipeResponse(
    @SerializedName("idMeal") val id:String,
    @SerializedName("strMeal") val name:String,
    @SerializedName("strMealThumb") val imgeUrl:String
)