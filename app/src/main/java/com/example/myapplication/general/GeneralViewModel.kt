package com.example.myapplication.general

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class GeneralViewModel : ViewModel() {
    protected val disposableContainer = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposableContainer.clear()
    }
}