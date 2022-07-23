package com.abdelaziz.tread

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.abdelaziz.tread.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Connect the binding
        val binding = DataBindingUtil.inflate<FragmentAddBinding>(
            inflater, R.layout.fragment_add, container, false)

        binding.shoe = Shoe("", 0.0, "", "")
        binding.viewModel = viewModel

        viewModel.shoeList.observe(viewLifecycleOwner) {
            findNavController().navigateUp()
        }

        binding.cancelBtn.setOnClickListener{
            findNavController().navigateUp()
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}
