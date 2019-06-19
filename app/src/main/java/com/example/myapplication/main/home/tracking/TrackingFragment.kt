package com.example.myapplication.main.home.tracking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.mangers.UserManager
import com.example.myapplication.databinding.FragmentTrackingBinding
import com.example.myapplication.general.GeneralFragment

class TrackingFragment : GeneralFragment<TrackingViewModel>() {
    private val userManager: UserManager = UserManager()

    override fun bindLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        val trackingViewDataBinding: FragmentTrackingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_tracking, container, false)
        viewModel = ViewModelProviders.of(this, TrackingViewModel.createFactory(userManager))
            .get(TrackingViewModel::class.java)
        return trackingViewDataBinding.root
    }
}