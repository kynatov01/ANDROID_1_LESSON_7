package com.example.android_1_lesson_7.data

data class DogModel(
    val imageDog: String? = null ,
    val nameDog: String? = null,
    val detailDog: String? = null
) : java.io.Serializable{
    fun getImageUri(): String? {
        return imageDog
    }
}