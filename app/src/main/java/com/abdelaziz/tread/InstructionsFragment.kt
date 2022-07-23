package com.abdelaziz.tread

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.abdelaziz.tread.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Connect the binding
        val binding = DataBindingUtil.inflate<FragmentInstructionsBinding>(
            inflater, R.layout.fragment_instructions, container, false)

        binding.button.setOnClickListener{
            view?.findNavController()?.navigate(InstructionsFragmentDirections.actionInstructionsFragmentToHomeFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}