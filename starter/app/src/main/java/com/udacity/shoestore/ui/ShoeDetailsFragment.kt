package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeListViewModel


class ShoeDetailsFragment : Fragment() {
    private val shoesViewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.lifecycleOwner = this
        binding.shoeListViewModel = shoesViewModel

        binding.save.setOnClickListener {
            shoesViewModel.addShoe(shoesViewModel.shoe)
            view?.findNavController()?.navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }

        binding.cancel.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }
        return binding.root
    }
}