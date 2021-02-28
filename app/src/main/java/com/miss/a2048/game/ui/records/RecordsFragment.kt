package com.miss.a2048.game.ui.records

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a2048clone.R
import com.example.a2048clone.databinding.FragmentRecordsBinding
import com.example.a2048clone.databinding.SplashFragmentBinding
import com.miss.a2048.game.adapters.RecordsAdapter
import com.miss.a2048.game.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class RecordsFragment : Fragment(R.layout.fragment_records) {

    private val viewModel : RecordsViewModel by viewModel()
    private val binding by viewBinding(FragmentRecordsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList()
        viewModel.recordsList.observe(viewLifecycleOwner){
            val adapter = RecordsAdapter(it)
            binding.recycler.adapter = adapter
            binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        }
    }

}