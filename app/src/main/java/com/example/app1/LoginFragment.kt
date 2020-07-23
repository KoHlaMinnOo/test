package com.example.app1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.app1.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private val name="kkk"
    private val phone="123"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding:FragmentLoginBinding=DataBindingUtil.inflate(
            inflater,R.layout.fragment_login,container,false
        )


        //Text Sign up
        binding.signUpText.setOnClickListener {
            view:View ->
            binding.editTextName.setText(null)
            binding.editTextPhone.setText(null)
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_signUpFragment)
        }


        //Btn Login
        binding.btnLogin.setOnClickListener {
            val etname=binding.editTextName.text.toString()
            val etphone=binding.editTextPhone.text.toString()

            if (TextUtils.isEmpty(etname)){
                binding.editTextName.setError("Enter your name")
                binding.editTextName.requestFocus()
                return@setOnClickListener
            }else if (TextUtils.isEmpty(etphone)){
                binding.editTextPhone.setError("Enter your phone")
                binding.editTextPhone.requestFocus()
                return@setOnClickListener
            }else if (etname==name && etphone==phone){
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_memberFragment)
            }else{
                binding.editTextName.setText(null)
                binding.editTextPhone.setText(null)
                binding.editTextName.requestFocus()
                Toast.makeText(context, "Name or Password Incorrect", Toast.LENGTH_SHORT).show()
            }

        }
        return binding.root

    }


}