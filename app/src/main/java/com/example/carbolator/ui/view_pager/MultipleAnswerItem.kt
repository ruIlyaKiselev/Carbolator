package com.example.carbolator.ui.view_pager

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.example.carbolator.R
import com.example.carbolator.databinding.MultipleAnswerItemBinding
import com.example.carbolator.domain.Question

class MultipleAnswerItem: Fragment() {
    private lateinit var binding: MultipleAnswerItemBinding

    private var question: Question? = null
    private var callback: AnswerSelectListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MultipleAnswerItemBinding.inflate(layoutInflater)
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
            multipleAnswerQuestion.text = question.text

            question.questionList.forEach { questionText ->
                val checkBoxToAdd = CheckBox(requireContext())

                checkBoxToAdd.setTextColor(ContextCompat.getColor(requireContext(), R.color.text))

                checkBoxToAdd.buttonTintList = ColorStateList(
                    arrayOf(
                        intArrayOf(-android.R.attr.state_checked),
                        intArrayOf(android.R.attr.state_checked)
                    ), intArrayOf(
                        ContextCompat.getColor(requireContext(), R.color.text),
                        ContextCompat.getColor(requireContext(), R.color.text_dark)
                    )
                )

                checkBoxToAdd.textSize = 16f
                checkBoxToAdd.text = questionText

                checkBoxToAdd.setOnClickListener {
                    val selectedText = getSelectedRadioButtonText(multipleAnswerCheckBoxGroup)
                    Log.d("MyLog", selectedText.toString())
                    callback?.onSelect(question.id, selectedText)
                }

                multipleAnswerCheckBoxGroup.addView(checkBoxToAdd)
            }
        }
    }

    private fun getSelectedRadioButtonText(checkBoxGroup: LinearLayout): List<String> {
        val countOfChild = checkBoxGroup.childCount
        val result = mutableListOf<String>()

        for (childView in checkBoxGroup.children) {
            val checkBox = childView as CheckBox

            if (checkBox.isChecked) {
                result.add(checkBox.text.toString())
                Log.d("MyLog111", checkBox.text.toString())
            }
        }

        return result
    }
}