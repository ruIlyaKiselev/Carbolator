package com.example.carbolator.network.model.question


import com.google.gson.annotations.SerializedName

data class QuestionDtoItem(
    @SerializedName("answers")
    val possibleAnswersList: List<PossibleAnswer>?,
    @SerializedName("max_value")
    val maxValue: Int?,
    @SerializedName("min_value")
    val minValue: Int?,
    @SerializedName("next_question_id")
    val nextQuestionId: Int?,
    @SerializedName("question_id")
    val questionId: Int?,
    @SerializedName("type_answer")
    val typeAnswer: String?
)