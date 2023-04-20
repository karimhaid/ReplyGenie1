package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.databinding.ActivityMainBinding
import com.example.finalproject.ui.main.MainFragment
import com.example.finalproject.ui.main.MainViewModel
import com.example.finalproject.ui.main.ResponseFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
//
//    override fun APIResponseReceived(Response : String) {
//        Log.i("MainActivity","From CallBack")
//        val ResponseFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView4) as ResponseFragment
//        ResponseFragment.updateScreen(Response)
//    }

//    override fun sendResponse(Response: String) {
//        val ResponseFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView4) as ResponseFragment
//        ResponseFragment.updateScreen(Response)
//    }
}