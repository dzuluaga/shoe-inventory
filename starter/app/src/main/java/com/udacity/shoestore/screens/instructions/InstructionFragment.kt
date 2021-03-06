package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instruction,
            container,
            false
        )
        binding.lifecycleOwner = this

        binding.shoeListButton.setOnClickListener() { view ->
            view.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        }

        return binding.root
    }
}