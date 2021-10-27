package com.example.carbolator.ui.view_pager

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.util.Log
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.carbolator.R
import com.example.carbolator.databinding.OneAnswerItemBinding
import com.example.carbolator.domain.Question

class OneAnswerItem: Fragment() {
    private lateinit var binding: OneAnswerItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = OneAnswerItemBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }

    override fun onStart() {
        super.onStart()

        val question = arguments?.getParcelable("question") as Question?
        question?.let {
            bind(it)
        }
    }

    @SuppressLint("ResourceType")
    private fun bind(question: Question) {
        binding.apply {
            oneAnswerQuestion.text = question.text

            question.questionList.forEach {  question ->
                val radioButtonToAdd = RadioButton(requireContext())

                radioButtonToAdd.setTextColor(ContextCompat.getColor(requireContext(), R.color.text))

                radioButtonToAdd.buttonTintList = ColorStateList(
                    arrayOf(
                        intArrayOf(-android.R.attr.state_checked),
                        intArrayOf(android.R.attr.state_checked)
                    ), intArrayOf(
                        ContextCompat.getColor(requireContext(), R.color.text),
                        ContextCompat.getColor(requireContext(), R.color.text_dark)
                    )
                )

                radioButtonToAdd.setTextSize(20f)
                radioButtonToAdd.text = question

                oneAnswerRadioGroup.addView(radioButtonToAdd)
            }
        }
    }
}