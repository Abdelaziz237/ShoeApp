package com.abdelaziz.tread

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.abdelaziz.tread.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Connect the binding
        val binding = DataBindingUtil.inflate<FragmentSignupBinding>(
            inflater, R.layout.fragment_signup, container, false)

        binding.register.setOnClickListener{
            if (!(binding.username.editText?.text?.isEmpty()!!) && !(binding.password.editText?.text?.isEmpty()!!)){
                view?.findNavController()?.navigate(SignupFragmentDirections.actionSignupFragmentToWelcomeFragment())
            }else{
                binding.username.editText!!.error = "Required"
                binding.password.editText!!.error = "Required"
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}