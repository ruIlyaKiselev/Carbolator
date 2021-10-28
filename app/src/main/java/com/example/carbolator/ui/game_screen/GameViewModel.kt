package com.example.carbolator.ui.game_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carbolator.domain.Question
import com.example.carbolator.repository.CarbolatorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    val repository: CarbolatorRepository
): ViewModel() {

    private var mutableQuestions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = mutableQuestions

    private val selectedAnswers: MutableMap<Int, List<String>> = mutableMapOf()

    fun loadQuestions() {

        val handler = CoroutineExceptionHandler { _, exception ->
            Log.e("MyLog","CoroutineExceptionHandler got $exception")
        }

        viewModelScope.launch (Dispatchers.IO + handler) {
            mutableQuestions.postValue(repository.getQuestions())
        }
    }

    fun putAnswer(questionId: Int, questionList: List<String>) {
        selectedAnswers[questionId] = questionList
        selectedAnswers.forEach {
            Log.d("MyLog", it.toString())
        }
    }

    fun getAnswersList(): Map<Int, List<String>> = selectedAnswers
}