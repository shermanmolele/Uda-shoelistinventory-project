package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.login_fragment,
            container, false)

        binding.buttonSignIn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment2)
        }
        binding.buttonSignInExisting.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment2)
        }

        return binding.root
    }
}