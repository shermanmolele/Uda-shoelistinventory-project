package com.udacity.shoestore.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemListBinding
import com.udacity.shoestore.models.Shoe


class ShoeLayout: LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: ShoeItemListBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_item_list, this, false)

    fun loadShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            shoeName.text = shoe.name
            companyName.text = shoe.company
            shoeSize.text = shoe.size
            description.text = shoe.description
        }
    }
}