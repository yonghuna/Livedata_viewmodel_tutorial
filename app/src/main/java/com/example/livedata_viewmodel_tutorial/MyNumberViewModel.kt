package com.example.livedata_viewmodel_tutorial

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class  ActionType {
    PLUS, MINUS

}
//데이터 변경
// 뷰모델은 데이터의 변경사항을 알려주는 라이브 데이터 가지고있음
class MyNumberViewModel : ViewModel() {

    companion object{
        const val TAG: String = "로그"
    }
    // 뮤터블 라이브 데이터 - 수정 가능한 녀석
    // 라이브 데이터 - 값 변동 안됨

    private val _currenValue = MutableLiveData<Int>()

    val currentValue: LiveData<Int>
        get () = _currenValue


    // 초기값 설정
    init {
        Log.d(TAG, "MyNumberViewModel - 생성자 호출")
        _currenValue.value = 0

    }

    fun updateValue(actionType: ActionType, input: Int){
        when(actionType){
            ActionType.PLUS->
                _currenValue.value = _currenValue.value?.plus(input)
            ActionType.MINUS->
                _currenValue.value = _currenValue.value?.minus(input)
        }
    }



}