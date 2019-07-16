package com.example.myapplication.main.home.myslice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.mangers.UserManager
import com.example.myapplication.general.GeneralViewModel

class MySliceViewModel(val userManager: UserManager) :
    GeneralViewModel() {

    val liveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}