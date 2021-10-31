package com.example.carbolator.network.model.question


import com.google.gson.annotations.SerializedName

data class QuestionsDtoItem(
    @SerializedName("answers")
    val answerComponents: List<AnswerComponent>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("next_question_id")
    val nextQuestionId: Int?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("type_answer")
    val typeAnswer: String?
)