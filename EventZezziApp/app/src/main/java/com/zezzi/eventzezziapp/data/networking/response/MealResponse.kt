package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(val categories: List<MealResponse>) : List<Any> {
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun contains(element: Any): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Any>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): Any {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: Any): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Any> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: Any): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<Any> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<Any> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<Any> {
        TODO("Not yet implemented")
    }
}

data class MealResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)