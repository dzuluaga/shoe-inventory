package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeAdapter

class ShoeListFragment : Fragment() {
    private lateinit var viewModel: ActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
        binding.lifecycleOwner = this

        viewModel = (activity as MainActivity).viewModel

        binding.floatingActionButton.setOnClickListener { view ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        // Create a ShoeAdapter using the list_item layout and the shoe list
        val adapter = ShoeAdapter(this.context, R.layout.list_item, viewModel.shoeList.value)

        // Setting the adapter to list
        binding.listView!!.adapter = adapter

        return binding.root
    }
}