package com.example.carbolator.ui.game_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.carbolator.databinding.FragmentGameBinding
import com.example.carbolator.domain.Question
import com.example.carbolator.ui.view_pager.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()
    private lateinit var binding: FragmentGameBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private val questions = mutableListOf<Question>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGameBinding.inflate(layoutInflater)
        val view = binding.root

        viewPagerAdapter = ViewPagerAdapter(this, questions)
        binding.gameScreenViewPager.adapter = viewPagerAdapter

        viewModel.questions.observe(viewLifecycleOwner) {
            it.forEach { question ->
                questions.addAll(it)
                viewPagerAdapter.notifyDataSetChanged()
            }
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadQuestions()
    }
}