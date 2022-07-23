package com.abdelaziz.tread

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel(){

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    fun addShoe(shoe: Shoe){
        shoe.images = listOf(R.drawable.new_sneakers)
        _shoeList.value = _shoeList.value?.plus(shoe) ?: listOf(shoe)
    }
}