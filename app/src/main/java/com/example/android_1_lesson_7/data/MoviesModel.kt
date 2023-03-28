package com.example.android_1_lesson_7.data

data class MoviesModel(
    val imageMovies: String? = null ,
    val nameMovies: String? = null,
    val detailMovies: String? = null
) : java.io.Serializable {
    fun getImageUri(): String? {
        return imageMovies
    }
}
