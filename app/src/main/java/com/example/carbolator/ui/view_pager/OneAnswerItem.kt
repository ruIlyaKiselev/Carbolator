package com.example.carbolator.ui.view_pager

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.carbolator.R
import com.example.carbolator.databinding.OneAnswerItemBinding
import com.example.carbolator.domain.Question

class OneAnswerItem: Fragment() {
    private lateinit var binding: OneAnswerItemBinding

    private var question: Question? = null
    private var callback: AnswerSelectListener? = null

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

        question = arguments?.getParcelable<Question?>("question")
        question?.let {
            bind(it)
        }

        callback = arguments?.getParcelable<AnswerSelectListener?>("listener")
    }

    @SuppressLint("ResourceType")
    private fun bind(question: Question) {
        binding.apply {
            oneAnswerQuestion.text = question.text

            question.questionList.forEach {  questionText ->
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

                radioButtonToAdd.textSize = 16f
                radioButtonToAdd.text = questionText

                oneAnswerRadioGroup.addView(radioButtonToAdd)
            }

            oneAnswerRadioGroup.setOnCheckedChangeListener { radioGroup, i ->
                val selectedText = getSelectedRadioButtonText(radioGroup)
                Log.d("MyLog", selectedText)
                callback?.onSelect(question.id, listOf(selectedText))
            }
        }
    }

    private fun getSelectedRadioButtonText(radioGroup: RadioGroup): String {
        val radioButtonID: Int = radioGroup.checkedRadioButtonId
        val radioButton: View = radioGroup.findViewById(radioButtonID)
        val idx: Int = radioGroup.indexOfChild(radioButton)
        val selectedRadioButton = radioGroup.getChildAt(idx) as RadioButton
        return selectedRadioButton.text.toString()
    }
}