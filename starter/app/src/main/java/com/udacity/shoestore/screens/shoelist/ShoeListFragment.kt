package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeCustomLayoutBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
    private val viewModel: ActivityViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding
    // private lateinit var shoeLayoutBinding: ShoeCustomLayoutBinding

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

        // Add a view to the list LinearLayout with a shoe in the shoeList
        viewModel.shoeList.value?.forEach { shoe ->
            Log.i("adding shoes", shoe.toString())
            binding.shoeListLinearLayout.addView(this.createShoeLayout(shoe, inflater, container))
        }

        viewModel.shoeAdded.observe(viewLifecycleOwner, { shoeAdded ->
            if (shoeAdded) {
                binding.shoeListLinearLayout.addView(this.createShoeLayout(viewModel.shoe.value!!, inflater, container))
                viewModel.addShoeToList(viewModel.shoe.value!!)
                viewModel.resetShoeAdded()
            }
        })

        return binding.root
    }

    private fun createShoeLayout(shoe: Shoe, inflater: LayoutInflater, container: ViewGroup?): View {
        val shoeLayoutBinding: ShoeCustomLayoutBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_custom_layout,
            container,
            false
        )
        // Bind the shoe to the layout view created programmatically
        shoeLayoutBinding.shoe = shoe

        return shoeLayoutBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.overflow_menu, menu)
    }
}