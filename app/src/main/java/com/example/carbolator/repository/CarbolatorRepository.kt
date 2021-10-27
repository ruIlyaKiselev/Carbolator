package com.example.carbolator.repository

import com.example.carbolator.domain.Answer
import com.example.carbolator.domain.Question

interface CarbolatorRepository {
    suspend fun getQuestions(): List<Question>
    suspend fun postAnswers(answers: List<Answer>)
}