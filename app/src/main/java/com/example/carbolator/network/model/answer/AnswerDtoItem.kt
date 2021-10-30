package com.example.carbolator.network.model.answer


import com.google.gson.annotations.SerializedName

data class AnswerDtoItem(
    @SerializedName("answers")
    val answers: List<String>?,
    @SerializedName("question_id")
    val questionId: String?
)