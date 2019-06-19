package com.example.myapplication.main.home.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.mangers.UserManager
import com.example.myapplication.general.GeneralViewModel

class BrowsePizzeriasViewModel(val userManager: UserManager) : GeneralViewModel() {
    companion object {
        fun createFactory(userManager: UserManager): BrowseViewModelFactory = BrowseViewModelFactory(userManager)
    }
}

@Suppress("UNCHECKED_CAST")
class BrowseViewModelFactory(val userManager: UserManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(BrowsePizzeriasViewModel::class.java)) {
            BrowsePizzeriasViewModel(userManager) as T
        } else {
            throw IllegalArgumentException("TrackingViewModel Not Found")
        }
    }
}