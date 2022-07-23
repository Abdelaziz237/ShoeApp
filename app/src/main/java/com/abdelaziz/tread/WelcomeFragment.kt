package com.abdelaziz.tread

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.abdelaziz.tread.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Connect the binding
        val binding = FragmentWelcomeBinding.inflate( inflater, container, false)

        binding.toInstructions.setOnClickListener{
            view?.findNavController()?.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}