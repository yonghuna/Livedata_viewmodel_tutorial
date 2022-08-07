package com.example.livedata_viewmodel_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "로그"
    }

    lateinit var  myNumberViewModel: MyNumberViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myNumberViewModel = ViewModelProviders(this).get(MyNumberViewModel::class.java)
        myNumberViewModel.currentValue
    }
}