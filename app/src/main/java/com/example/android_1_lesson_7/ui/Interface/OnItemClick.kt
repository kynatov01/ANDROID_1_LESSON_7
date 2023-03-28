package com.example.android_1_lesson_7.ui.Interface

import com.example.android_1_lesson_7.data.DogModel

interface OnItemClick {
    fun onShortClickForDog(dogModel: DogModel)
}