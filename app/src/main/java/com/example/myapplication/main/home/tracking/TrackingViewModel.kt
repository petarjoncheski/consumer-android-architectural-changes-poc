package com.example.myapplication.main.home.tracking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.mangers.UserManager
import com.example.myapplication.general.GeneralViewModel

class TrackingViewModel(val userManager: UserManager) : GeneralViewModel() {
    companion object {
        fun createFactory(userManager: UserManager): TrackingViewModelFactory = TrackingViewModelFactory(userManager)
    }
}

@Suppress("UNCHECKED_CAST")
class TrackingViewModelFactory(val userManager: UserManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TrackingViewModel::class.java)) {
            TrackingViewModel(userManager) as T
        } else {
            throw IllegalArgumentException("TrackingViewModel Not Found")
        }
    }
}