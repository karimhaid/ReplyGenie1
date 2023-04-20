package com.example.finalproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentMainBinding
import java.lang.Thread.sleep

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding : FragmentMainBinding
    private var EmailTextWatcher= object : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            var From=binding.EtFrom.getText().toString().trim()
            var To=binding.EtTo.getText().toString().trim()
            var Message=binding.EditTextEmail.getText().toString().trim()

            binding.BtnGenerate.setEnabled(!From.isEmpty() && !To.isEmpty() && !Message.isEmpty())
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.BtnFormal.setOnClickListener(){
            //if  this is the first time the button is clicked
            // update the tone choice and disable other tone buttons
            //we increment the choice (0,1) if 0 this is the first time clicked
            //if 1 this is the second time so unselect button and enable the rest of the button

            if(viewModel.getButtonChoice()==0){
                viewModel.setEmailTone("Formal")

                binding.BtnFunctual.isEnabled=false
                binding.BtnInformal.isEnabled=false

                binding.EtTo.isFocusable=true
                binding.EtTo.isFocusableInTouchMode=true

                binding.EtFrom.isFocusable=true
                binding.EtFrom.isFocusableInTouchMode=true

                binding.EditTextEmail.isFocusable=true
                binding.EditTextEmail.isFocusableInTouchMode=true



        }
            else{
                viewModel.setEmailFrom("")
                binding.BtnFunctual.isEnabled=true
                binding.BtnInformal.isEnabled=true

                binding.EtTo.isFocusable=false
                binding.EtTo.isFocusableInTouchMode=false

                binding.EtFrom.isFocusable=false
                binding.EtFrom.isFocusableInTouchMode=false

                binding.EditTextEmail.isFocusable=false
                binding.EditTextEmail.isFocusableInTouchMode=false

            }

            viewModel.incrementButtonChoice()
        }
        binding.BtnFunctual.setOnClickListener(){
            //if  this is the first time the button is clicked
            // update the tone choice and disable other tone buttons
            //we increment the choice (0,1) if 0 this is the first time clicked
            //if 1 this is the second time so unselect button and enable the rest of the button

            if(viewModel.getButtonChoice()==0){
                viewModel.setEmailTone("Functual")
                binding.BtnFormal.isEnabled=false
                binding.BtnInformal.isEnabled=false

                binding.EtTo.isFocusable=true
                binding.EtTo.isFocusableInTouchMode=true

                binding.EtFrom.isFocusable=true
                binding.EtFrom.isFocusableInTouchMode=true

                binding.EditTextEmail.isFocusable=true
                binding.EditTextEmail.isFocusableInTouchMode=true
            }
            else{
                viewModel.setEmailTone("")
                binding.BtnFormal.isEnabled=true
                binding.BtnInformal.isEnabled=true

                binding.EtTo.isFocusable=false
                binding.EtTo.isFocusableInTouchMode=false

                binding.EtFrom.isFocusable=false
                binding.EtFrom.isFocusableInTouchMode=false

                binding.EditTextEmail.isFocusable=false
                binding.EditTextEmail.isFocusableInTouchMode=false

            }

            viewModel.incrementButtonChoice()

        }
        binding.BtnInformal.setOnClickListener(){
            //if  this is the first time the button is clicked
            // update the tone choice and disable other tone buttons
            //we increment the choice (0,1) if 0 this is the first time clicked
            //if 1 this is the second time so unselect button and enable the rest of the button
            //if a button is selected then enable the text fields, this is to prevent

            if(viewModel.getButtonChoice()==0){
                viewModel.setEmailTone("Informal")
                binding.BtnFunctual.isEnabled=false
                binding.BtnFormal.isEnabled=false

                binding.EtTo.isFocusable=true
                binding.EtTo.isFocusableInTouchMode=true

                binding.EtFrom.isFocusable=true
                binding.EtFrom.isFocusableInTouchMode=true

                binding.EditTextEmail.isFocusable=true
                binding.EditTextEmail.isFocusableInTouchMode=true
            }
            else{
                viewModel.setEmailTone("")
                binding.BtnFunctual.isEnabled=true
                binding.BtnFormal.isEnabled=true

                binding.EtTo.isFocusable=false
                binding.EtTo.isFocusableInTouchMode=false

                binding.EtFrom.isFocusable=false
                binding.EtFrom.isFocusableInTouchMode=false

                binding.EditTextEmail.isFocusable=false
                binding.EditTextEmail.isFocusableInTouchMode=false

            }

            viewModel.incrementButtonChoice()
        }
        binding.EtFrom.addTextChangedListener(EmailTextWatcher)
        binding.EtTo.addTextChangedListener(EmailTextWatcher)
        binding.EditTextEmail.addTextChangedListener(EmailTextWatcher)
        binding.BtnGenerate.setOnClickListener(){
            viewModel.setEmailFrom(binding.EtFrom.text.toString())
            viewModel.setEmailTo(binding.EtTo.text.toString())
            viewModel.setEmailMsg(binding.EditTextEmail.text.toString())
            viewModel.GenerateResponse()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }



}