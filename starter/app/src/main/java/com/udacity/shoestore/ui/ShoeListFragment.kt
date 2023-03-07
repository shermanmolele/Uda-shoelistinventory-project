package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeListViewModel

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_list_fragment,
            container, false
        )
        binding.lifecycleOwner = this
        viewModel.getShoeLiveData().observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                createShoes(it)
            }
        }
        binding.fab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun createShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.shoeList
            shoes.forEach { shoe ->
                val shoeLayout = ShoeLayout(context)
                shoeLayout.loadShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }
    }
}