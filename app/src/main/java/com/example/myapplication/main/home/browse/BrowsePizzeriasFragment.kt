package com.example.myapplication.main.home.browse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.mangers.UserManager
import com.example.myapplication.databinding.FragmentBrowsePizzeriasBinding
import com.example.myapplication.general.GeneralFragment

class BrowsePizzeriasFragment : GeneralFragment<BrowsePizzeriasViewModel>() {
    private val userManager: UserManager = UserManager()

    override fun bindLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        val browseViewDataBinding: FragmentBrowsePizzeriasBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_browse_pizzerias, container, false)
        viewModel = ViewModelProviders.of(this, BrowsePizzeriasViewModel.createFactory(userManager))
            .get(BrowsePizzeriasViewModel::class.java)
        return browseViewDataBinding.root
    }
}