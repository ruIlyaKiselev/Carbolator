package com.example.carbolator.network.model.question


import com.google.gson.annotations.SerializedName

data class PossibleAnswer(
    @SerializedName("next_question_limit_id")
    val nextQuestionLimitId: Int?,
    @SerializedName("text")
    val text: String?
)