package com.zezzi.eventzezziapp.data.networking.response
import com.google.gson.annotations.SerializedName
data class FoodRes(@SerializedName("meals") val foodInstruction: List<FoodResponse>)

data class FoodResponse(
    @SerializedName("MealsId") val id: String,
    @SerializedName("MealsStri") val meal: String,
    @SerializedName("InstStr") val instrucs: String?,
    @SerializedName("MealsImStr") val imageUrl: String,
    @SerializedName("VideoStr") val video: String?,

    @SerializedName("Ingre1") val ingred1: String?,
    @SerializedName("Ingre2") val ingred2: String?,
    @SerializedName("Ingre3") val ingred3: String?,
    @SerializedName("Ingre4") val ingred4: String?,
    @SerializedName("Ingre5") val ingred5: String?,

    @SerializedName("part1") val parte1: String?,
    @SerializedName("part2") val parte2: String?,
    @SerializedName("part3") val parte3: String?,
    @SerializedName("part4") val parte4: String?,
    @SerializedName("part5") val parte5: String?,


    )





