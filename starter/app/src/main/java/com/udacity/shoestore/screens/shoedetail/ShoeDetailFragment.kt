package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private lateinit var activityViewModel: ActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        activityViewModel = (activity as MainActivity).viewModel
        binding.activityViewModel = activityViewModel

        activityViewModel.shoeAdded.observe(viewLifecycleOwner, Observer { shoeAdded ->
            if (shoeAdded) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                activityViewModel.resetShoeAdded()
            }
        })
        binding.shoe = Shoe("", 0.0, "", "", mutableListOf("ic_nike_shoes_fade"))

        binding.lifecycleOwner = this

        activityViewModel.goBackToShoeList.observe(viewLifecycleOwner, Observer { goBackToShoeList ->
            Log.i("shoeAdded ", goBackToShoeList.toString())
            if (goBackToShoeList) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                activityViewModel.resetGoBackToShoeList()
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }

}