package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName
data class RecipesR(@SerializedName("meals") val recipes: List<RecipeResponse>)
data class RecipeRes(
    @SerializedName("MealsId") val id: String,
    @SerializedName("MealsStri") val meal: String,
    @SerializedName("MealsImStr") val imageUrl: String,
)

//Modificaciones listas