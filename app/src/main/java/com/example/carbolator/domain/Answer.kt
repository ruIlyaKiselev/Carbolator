package com.example.carbolator.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Answer (
    val id: Int,
    val selectedAnswers: List<String>
): Parcelable
