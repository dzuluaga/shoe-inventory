package com.udacity.shoestore.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.udacity.shoestore.databinding.ListItemBinding
import androidx.databinding.BindingAdapter

// loadImage resolves the resource id to display the image from string array in shoe.images
@BindingAdapter("android:src")
fun loadImage(view: ImageView, src: String) {
    val resId = view.context.resources.getIdentifier(src , "drawable", view.context.packageName)
    view.setImageResource(resId)
}
class ShoeAdapter(context: Context?, textViewResourceId: Int, objects: MutableList<Shoe>?) :
    ArrayAdapter<Shoe?>(context!!, textViewResourceId, objects as MutableList<Shoe?>) {
    private var shoeList = mutableListOf<Shoe>()

    // Returns total number of items to be displayed in the list.
    // It counts the value from the arraylist size
    override fun getCount(): Int {
        return super.getCount()
    }

    // This function implicitly gets called when the listItem view is ready
    // to be displayed. Here we set the layout and add data to the views
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
        // Setting layout
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val binding: ListItemBinding = ListItemBinding.inflate(layoutInflater, viewGroup, false)

        // Used for two way binding, so all EditText views override the values directly to shoe
        // instances
        binding.shoe = shoeList[position]
        return binding.root
    }

    init {
        shoeList = objects!!
    }
}