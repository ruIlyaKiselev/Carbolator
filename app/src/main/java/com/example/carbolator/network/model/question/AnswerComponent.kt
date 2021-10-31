package com.example.carbolator.network.model.question


import com.google.gson.annotations.SerializedName

data class AnswerComponent(
    @SerializedName("next_question_id")
    val nextQuestionId: Any?,
    @SerializedName("text")
    val text: String?
)