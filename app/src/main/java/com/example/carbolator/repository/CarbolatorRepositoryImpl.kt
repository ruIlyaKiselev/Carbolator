package com.example.carbolator.repository

import com.example.carbolator.domain.Answer
import com.example.carbolator.domain.Question
import com.example.carbolator.domain.QuestionType

class CarbolatorRepositoryImpl: CarbolatorRepository {

    override suspend fun getQuestions(): List<Question> {
        return generateTestQuestions()
    }

    override suspend fun postAnswers(answers: List<Answer>) {

    }

    private fun generateTestQuestions(): List<Question> {
        val result = mutableListOf<Question>()

        result.apply {

            add(
                Question(
                    id = 1,
                    text = "Какие у вас пищевые привычки?",
                    questionList = listOf(
                        "Мясо с каждым приемом пищи",
                        "Мясо иногда",
                        "Не ем говядину",
                        "Ем мясо очень редко",
                        "Я вегетарианец",
                        "Я веган"
                    ),
                    type = QuestionType.OneAnswer,
                    nextQuestionId = 2
                )
            )

            add(
                Question(
                    id = 2,
                    text = "Какие из следующих ресурсосберегающих приспособлений установлены в вашем доме?",
                    questionList = listOf(
                        "Энергосберегающие лампочки",
                        "Утеплитель крыши",
                        "Утеплитель стен и межпанельных швов",
                        "Конденсирующий водонагреватель",
                        "Двойное остекление",
                        "Насадки для ослабления напора воды",
                        "Солнечные панели",
                        "Солнечные нагреватели воды"
                    ),
                    type = QuestionType.MultipleAnswer,
                    nextQuestionId = 3
                )
            )

            add(
                Question(
                    id = 3,
                    text = "Сколько рейсов туда–обратно вы совершили в течение прошедшего года на следующие расстояния?",
                    questionList = listOf(
                        "До 500 км (как Москва–Воронеж)",
                        "До 1250 км (как Москва–Архангельск)",
                        "До 2500 км (как Москва–Амстердам)",
                        "До 5500 км (как Москва–Иркутск)",
                        "До 9000 км (как Москва–Владивосток)",
                        "До 17500 км (как Москва–Веллингтон)"
                    ),
                    type = QuestionType.MultipleAnswer,
                    nextQuestionId = -1
                )
            )
        }

        return result
    }
}