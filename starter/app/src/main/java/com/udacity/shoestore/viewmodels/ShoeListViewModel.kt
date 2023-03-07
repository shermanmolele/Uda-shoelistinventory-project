package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val shoes =  MutableLiveData<MutableList<Shoe>>(mutableListOf())
    var shoe = Shoe()
        set(value) {
            if(value != field) {
                field = value
            }
        }

    fun getShoeLiveData(): LiveData<MutableList<Shoe>> = shoes

    fun addShoe(item: Shoe?) {
        item?.let {
            shoes.value?.add(item)
        }
    }
}
