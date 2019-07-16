package com.example.myapplication.general

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GeneralViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return creator() as T
    }
}