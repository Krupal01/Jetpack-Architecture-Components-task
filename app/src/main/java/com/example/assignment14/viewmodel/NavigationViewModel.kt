package com.example.assignment14.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavigationViewModel : ViewModel() {

    var swScr1ToScr2 = MutableLiveData<Boolean>(false)
    var swScr2ToScr3 = MutableLiveData<Boolean>(false)


}