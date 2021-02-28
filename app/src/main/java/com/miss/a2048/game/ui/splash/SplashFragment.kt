package com.miss.a2048.game.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a2048clone.R
import com.example.a2048clone.databinding.SplashFragmentBinding
import com.example.a2048clone.game.MainActivity
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment(R.layout.splash_fragment) {


    private val viewModel : SplashViewModel by viewModel()
    private val binding by viewBinding(SplashFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startButton.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }
        binding.recordButton.setOnClickListener {
            findNavController().navigate(R.id.recordsFragment)
        }
    }


}