package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ActivityViewModel: ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() {
            return _shoeList
        }

    private var _shoeAdded = MutableLiveData<Boolean>()
    val shoeAdded : LiveData<Boolean>
        get() {
            return _shoeAdded
        }

    private var _goBackToShoeList = MutableLiveData<Boolean>()
    val goBackToShoeList : LiveData<Boolean>
        get() {
            return _goBackToShoeList
        }

    init {
        resetList()
    }
    fun addShoe(shoe : Shoe) {
        _shoeList.value?.add(shoe)
        _shoeAdded.value = true
    }

    fun resetShoeAdded() {
        _shoeAdded.value = false
    }

    fun goBackToShoeList() {
        _goBackToShoeList.value = true
    }

    fun resetGoBackToShoeList() {
        _goBackToShoeList.value = false
    }

    private fun resetList()  {
        _shoeList.value = mutableListOf(
            Shoe("Nike Vapor", Integer(10).toDouble(), "Nike", "Great for running", mutableListOf("ic_nike_shoes_fade")),
            Shoe("Brooks Ghost 1", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("sneaker")),
            Shoe("Brooks Ghost 13", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("three_stripes_shoe")),
            Shoe("Brooks Ghost 14", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("ic_nike_shoes_fade")),
            Shoe("Brooks Ghost 15", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("brooks")),
            Shoe("Brooks Ghost 16", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("brooks")),
            Shoe("Brooks Ghost 17", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("brooks")),
            Shoe("Brooks Ghost 18", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("brooks")),
            Shoe("Brooks Ghost 19", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("brooks")),
            Shoe("Brooks Ghost 20", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("brooks")),
            Shoe("Brooks Ghost 21", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("brooks")),
            Shoe("Brooks Ghost 22", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("brooks")),
            Shoe("Brooks Ghost 23", Integer(11).toDouble(), "Brooks", "Awesome for running", mutableListOf("brooks")))
    }
}