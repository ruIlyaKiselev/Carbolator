package com.example.carbolator.network

import com.example.carbolator.network.model.answer.AnswerDto
import com.example.carbolator.network.model.question.QuestionsDto
import retrofit2.http.GET
import retrofit2.http.POST

interface CarbolatorService {

    @GET("questions")
    suspend fun getAllQuestions(): QuestionsDto

    @POST("storeAnswers")
    suspend fun postAnswers(answers: List<AnswerDto>)
}