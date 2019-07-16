package com.example.myapplication.main.home.myslice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.mangers.UserManager
import com.example.myapplication.databinding.FragmentMySliceBinding
import com.example.myapplication.general.GeneralFragment
import com.example.myapplication.general.GeneralViewModelFactory

class MySliceFragment : GeneralFragment<MySliceViewModel>() {
    private val userManager: UserManager = UserManager()

    override fun bindLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        val mySliceViewDataBinding: FragmentMySliceBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_slice, container, false)
        viewModel = ViewModelProviders.of(this, GeneralViewModelFactory { MySliceViewModel(userManager) })
            .get(MySliceViewModel::class.java)
        return mySliceViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel?.liveData?.observe(viewLifecycleOwner, Observer {
            //TODO handle the changes from the ViewModel
        })
    }
}