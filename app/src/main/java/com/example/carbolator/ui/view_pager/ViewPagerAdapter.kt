package com.example.carbolator.ui.view_pager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.carbolator.domain.Question
import com.example.carbolator.domain.QuestionType

class ViewPagerAdapter(
    fragment: Fragment,
    val data: MutableList<Question>
): FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        val question = data[position]

        Log.d("MyLog", "FROM ADAPTER!!!!" + question.toString())

        when(question.type) {

            QuestionType.OneAnswer -> {
                val fragment = OneAnswerItem()
                fragment.arguments = Bundle()
                fragment.arguments?.putParcelable("question", question)
                return fragment
            }

            QuestionType.MultipleAnswer -> {
                val fragment = OneAnswerItem()
                fragment.arguments = Bundle()
                fragment.arguments?.putParcelable("question", question)
                return fragment
            }

            QuestionType.SelectorsAnswer -> {
                val fragment = OneAnswerItem()
                fragment.arguments = Bundle()
                fragment.arguments?.putParcelable("question", question)
                return fragment
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}