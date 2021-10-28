package com.example.carbolator.ui.view_pager

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AnswerSelectListener(val selectAction: (Int, List<String>) -> Unit): Parcelable {
    fun onSelect(questionId: Int, answersList: List<String>) {
        selectAction(questionId, answersList)
    }
}