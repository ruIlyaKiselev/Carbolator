package com.example.carbolator.network

import com.example.carbolator.network.model.answer.AnswerDto
import com.example.carbolator.network.model.question.QuestionsDto
import retrofit2.http.GET
import retrofit2.http.POST

interface CarbolatorService {

    @GET("questions/all")
    suspend fun getAllQuestions(): QuestionsDto

    @POST("questions/create")
    suspend fun postAnswers(answers: List<AnswerDto>)
}