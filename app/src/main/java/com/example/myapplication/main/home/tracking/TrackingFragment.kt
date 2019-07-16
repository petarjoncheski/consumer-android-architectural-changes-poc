package com.example.myapplication.main.home.tracking

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.ReviewOrderActivity
import com.example.myapplication.mangers.UserManager
import com.example.myapplication.databinding.FragmentTrackingBinding
import com.example.myapplication.general.GeneralFragment
import com.example.myapplication.general.GeneralViewModelFactory

class TrackingFragment : GeneralFragment<TrackingViewModel>() {
    private val userManager: UserManager = UserManager()

    override fun bindLayout(inflater: LayoutInflater, container: ViewGroup?): View =
        DataBindingUtil.inflate<FragmentTrackingBinding>(inflater, R.layout.fragment_tracking, container, false)
            .let {
                this.viewModel =
                    ViewModelProviders.of(this@TrackingFragment, GeneralViewModelFactory { TrackingViewModel(userManager) })
                        .get(TrackingViewModel::class.java)

                it.viewModel = this.viewModel
                it.root
            }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel?.also {
            /** IMPORTANT !!! for the observe method be sure to use [Fragment.getViewLifecycleOwner] */
            it.actions.observe(viewLifecycleOwner, Observer<TrackingViewModel.Actions> { action ->
                when (action) {
                    is TrackingViewModel.Actions.StartReviewOrderActivity -> startReviewOrderActivity()
                    is TrackingViewModel.Actions.ShowMessage -> showToast(action.text)
                }
            })
        }
    }

    private fun startReviewOrderActivity() {
        activity?.also {
            startActivity(Intent(it, ReviewOrderActivity::class.java))
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}