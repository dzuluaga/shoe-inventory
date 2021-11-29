package com.udacity.shoestore.models

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

// Shoe is BaseObservable for making two way binding shoe in the Shoe detail layout
@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()) : Parcelable, BaseObservable()