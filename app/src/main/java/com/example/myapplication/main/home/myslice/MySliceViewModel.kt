package com.example.myapplication.main.home.myslice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.mangers.UserManager
import com.example.myapplication.general.GeneralViewModel

class MySliceViewModel(val userManager: UserManager) :
    GeneralViewModel() {
    companion object {
        fun createFactory(userManager: UserManager): MySliceViewModelFactory =
            MySliceViewModelFactory(userManager)
    }

    val liveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    @Suppress("UNCHECKED_CAST")
    class MySliceViewModelFactory(
        private val userManager: UserManager
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MySliceViewModel::class.java)) {
                MySliceViewModel(userManager) as T
            } else {
                throw IllegalArgumentException("MySliceViewModel Not Found")
            }
        }
    }
}