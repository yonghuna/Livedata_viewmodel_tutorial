package com.example.livedata_viewmodel_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val TAG: String = "로그"
    }

    lateinit var  myNumberViewModel: MyNumberViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)
        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "MainActivity - myNumberViewModel - currentValue 라이브 데이터 값 변경 : $it")
            number_textview.text = it.toString()
        })


        // 리스너 연결

        plus_btn.setOnClickListener(this)
        minus_btn.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        val userInput = userinput_edittext.text.toString().toInt()

        when(view){
            plus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS, userInput)
            minus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS, userInput)
        }
    }
}