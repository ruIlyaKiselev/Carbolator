package com.example.carbolator.ui.finish_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carbolator.R
import com.example.carbolator.databinding.FragmentFinishBinding
import com.example.carbolator.databinding.FragmentGameBinding

class FinishFragment : Fragment() {

    private lateinit var binding: FragmentFinishBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFinishBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }
}