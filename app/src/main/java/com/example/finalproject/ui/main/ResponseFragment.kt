package com.example.finalproject.ui.main

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentResponseBinding

class ResponseFragment : Fragment() {

    private lateinit var binding : FragmentResponseBinding
    private val viewModel: MainViewModel by activityViewModels()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.EmailMsgResponse.observe(viewLifecycleOwner,{EmailMsgResponse->binding.TvResponse.setText(EmailMsgResponse)})
        binding.TvResponse.movementMethod= ScrollingMovementMethod()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentResponseBinding.inflate(inflater,container,false)
        return binding.root
    }


    public fun updateScreen(Response : String) {
        Log.i("ResponseFragment",Response)
        binding.TvResponse.text=Response

    }


}