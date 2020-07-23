package com.example.app1

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.app1.databinding.FragmentSignUpBinding
import java.text.SimpleDateFormat
import java.util.*
import android.widget.ArrayAdapter as ArrayAdapter


class SignUpFragment : Fragment() {
    var isChecking=false
    var gender=""
    var radiotext=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentSignUpBinding=DataBindingUtil.inflate(
            inflater,R.layout.fragment_sign_up,container,false
        )

        //radio group

        binding.radioGroupOne.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){
                radioGroup: RadioGroup, i: Int ->
            if (i!=-1 && isChecking){
                isChecking=false
                binding.radioGroupTwo.clearCheck()
                val radioButton: RadioButton? = view?.findViewById(i)
                val radiotext= radioButton?.text.toString()
            }
            isChecking=true

        })

        binding.radioGroupTwo.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){
                radioGroup: RadioGroup, i: Int ->
            if (i!=-1 && isChecking){
                isChecking=false
                binding.radioGroupOne.clearCheck()
                val radioButton: RadioButton? = view?.findViewById(i)
                radiotext= radioButton?.text.toString()
            }
            isChecking=true

        })




        val gender_list= arrayOf("Choose your gender type","Male","Female")
        val adapter= activity?.applicationContext?.
                    let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,gender_list) }
        binding.spinner.adapter=adapter
        binding.spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(context, "select", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p0?.getItemAtPosition(p2)!="Choose your gender type"){
                    gender= p0?.getItemAtPosition(p2) as String
                }
            }

        }


        //calender
        var cal = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            binding.editTextBirthDate.setText(sdf.format(cal.time).toString())
        }

        binding.editTextBirthDate.setOnClickListener{
            view:View ->
            context?.let {
                DatePickerDialog(
                    it, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        }

        //Btn Sign Up
        binding.btnSignUp.setOnClickListener {
            val etname=binding.editTextName.text.toString()
            val etphone=binding.editTextPhone.text.toString()
            val etweight=binding.editTextWeight.text.toString()
            val etbirthdate=binding.editTextBirthDate.text.toString()
            if (TextUtils.isEmpty(etname)){
                binding.editTextName.setError("Enter You Name")
                binding.editTextName.requestFocus()
                return@setOnClickListener
            }else if (TextUtils.isEmpty(etphone)){
                binding.editTextPhone.setError("Enter Your Phone")
                binding.editTextPhone.requestFocus()
                return@setOnClickListener
            }else if (gender==""){
                val builder=AlertDialog.Builder(context)
                with(builder){
                    setTitle("Error")
                    setMessage("Choose your gender type")
                    setPositiveButton("OK",null)
                }
                val alertDialog=builder.create()
                alertDialog.show()
            }
            else if (TextUtils.isEmpty(etweight)){
                binding.editTextWeight.setError("Enter Your Weight")
                binding.editTextWeight.requestFocus()
                return@setOnClickListener
            }else if (TextUtils.isEmpty(etbirthdate)){
                binding.editTextBirthDate.setError("Enter Your Weight")
                binding.editTextBirthDate.requestFocus()
                return@setOnClickListener
            }else if (radiotext==""){
                val builder=AlertDialog.Builder(context)
                with(builder){
                    setTitle("Error")
                    setMessage("Choose your Blood_Type type")
                    setPositiveButton("OK",null)
                }
                val alertDialog=builder.create()
                alertDialog.show()
            }
            else {
                Navigation.findNavController(it).navigate(R.id.action_signUpFragment_to_memberFragment)
            }

            }

        //Login Text
        binding.loginText.setOnClickListener {
            view:View->


           Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_loginFragment)
        }
        return binding.root

    }

}

