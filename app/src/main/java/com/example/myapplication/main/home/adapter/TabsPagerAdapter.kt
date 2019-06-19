package com.example.myapplication.main.home.adapter

import androidx.fragment.app.FragmentManager
import com.example.myapplication.general.GeneralFragmentPagerAdapter

class TabsPagerAdapter(fm: FragmentManager, mGeneralPagerAdapter: GeneralPagerAdapterListener) :
    GeneralFragmentPagerAdapter(fm, mGeneralPagerAdapter)