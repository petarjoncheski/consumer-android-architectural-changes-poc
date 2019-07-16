package com.example.myapplication.main.home.tracking

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.general.GeneralViewModel
import com.example.myapplication.mangers.UserManager

class TrackingViewModel(
    val userManager: UserManager
) :
    GeneralViewModel() {

    init {
        userManager.id.subscribe()
            .also { disposableContainer.add(it) }
    }

    /**
     * Define all the actions that the view should consume.
     */
    sealed class Actions {
        object StartReviewOrderActivity : Actions()
        class ShowMessage(val text: String) : Actions()
    }

    val actions = MutableLiveData<Actions>()
    val message = ObservableField<String>("")

    /**
     * Note: You must call the setValue(T) method to update the LiveData object from the main thread.
     * If the code is executed in a worker thread, you can use the postValue(T) method instead to update the LiveData object.
     */
    fun consumeReviewOrderTapped() {
        actions.postValue(Actions.StartReviewOrderActivity)
    }

    fun consumeShowMessageTapped() {
        message.get()?.also {
            actions.postValue(Actions.ShowMessage(it))
        }
    }
}