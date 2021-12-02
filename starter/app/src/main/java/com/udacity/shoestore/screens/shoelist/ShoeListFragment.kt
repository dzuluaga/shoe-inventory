package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeAdapter

class ShoeListFragment : Fragment() {
    private val viewModel: ActivityViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
        binding.lifecycleOwner = this

        binding.floatingActionButton.setOnClickListener { view ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        // binds the list item with all the shoes
        val adapter = ShoeAdapter(this.context, R.layout.list_item, viewModel.shoeList.value)
        binding.listView.adapter = adapter

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shoeAdded.observe(viewLifecycleOwner, { shoeAdded ->
            if (shoeAdded) {
                viewModel.addShoeToList(viewModel.shoe.value!!)
                viewModel.resetShoeAdded()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.overflow_menu, menu)
    }
}