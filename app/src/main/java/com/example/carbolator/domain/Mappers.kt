package com.example.carbolator.domain

import com.example.carbolator.network.model.question.QuestionsDto

object Mappers {
    fun QuestionsDto.toDomain(): List<Question> {
        return this.map {

            val type: QuestionType = when(it.typeAnswer) {
                "radio" -> QuestionType.OneAnswer
                "checkbox" -> QuestionType.MultipleAnswer
                "counter" -> QuestionType.SelectorsAnswer
                else -> QuestionType.OneAnswer
            }

            Question(
                id = it.id ?: 0,
                text = it.text ?: "",
                questionList = it.answerComponents?.map { answerComponent -> answerComponent.text ?: "" } ?: listOf(),
                type = type,
                nextQuestionId = it.nextQuestionId ?: 0
            )
        }
    }
}