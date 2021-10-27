package com.example.carbolator.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question (
    val id: Int,
    val text: String,
    val questionList: List<String>,
    val type: QuestionType,
    val nextQuestionId: Int
): Parcelable