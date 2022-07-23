package com.abdelaziz.tread

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.abdelaziz.tread.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Connect the binding
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false)

        binding.confirmIn.setOnClickListener{
            if (!(binding.username.editText?.text?.isEmpty()!!) && !(binding.password.editText?.text?.isEmpty()!!)){
            view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }else{
                binding.username.editText!!.error = "Required"
                binding.password.editText!!.error = "Required"
            }
        }

        binding.signUp.setOnClickListener{
            view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}