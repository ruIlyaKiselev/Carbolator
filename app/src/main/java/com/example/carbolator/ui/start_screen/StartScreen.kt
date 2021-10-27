package com.example.carbolator.ui.start_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.carbolator.R
import com.example.carbolator.databinding.FragmentStartScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StartScreen : Fragment() {

    private lateinit var binding: FragmentStartScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentStartScreenBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()

        binding.startScreenButton.setOnClickListener {
            findNavController().navigate(R.id.fromStartToGame)
        }

        lifecycleScope.launch {
            requireActivity().findViewById<ConstraintLayout>(R.id.startScreenLoadingLayout).visibility = View.VISIBLE

            delay(2000)

            binding.startScreenLoadingLayout.visibility = View.GONE
            binding.startScreenGreetingLayout.visibility = View.VISIBLE
        }
    }

}