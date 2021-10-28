package com.example.carbolator.ui.game_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.carbolator.R
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

        viewPagerAdapter = ViewPagerAdapter(
            this,
            questions,
            viewModel::putAnswer
        )
        binding.gameScreenViewPager.adapter = viewPagerAdapter

        viewModel.questions.observe(viewLifecycleOwner) {
            questions.addAll(it)
            viewPagerAdapter.notifyDataSetChanged()
        }

        configureArrows()

        binding.gameScreenFinalButton.setOnClickListener {
            findNavController().navigate(R.id.fromGameToFinish)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadQuestions()
    }

    private fun configureArrows() {

        binding.apply {
            gameScreenNextButton.setOnClickListener {
                val currentItemNumber = gameScreenViewPager.currentItem
                val totalItemsNumber = viewPagerAdapter.itemCount - 1

                if (currentItemNumber < totalItemsNumber) {
                    gameScreenViewPager.currentItem = currentItemNumber + 1
                }
                else {
                    binding.apply {
                        gameScreenCardView.visibility = View.GONE
                        gameScreenFinalButton.visibility = View.VISIBLE
                    }
                }
            }
        }

        binding.apply {
            gameScreenPrevButton.setOnClickListener {
                val currentItemNumber = gameScreenViewPager.currentItem

                if (currentItemNumber > 0)
                    gameScreenViewPager.currentItem = currentItemNumber - 1
            }
        }

    }
}