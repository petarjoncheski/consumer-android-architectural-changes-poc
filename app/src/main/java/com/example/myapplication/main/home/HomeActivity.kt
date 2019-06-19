package com.example.myapplication.main.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.general.GeneralFragmentPagerAdapter
import com.example.myapplication.main.home.adapter.TabsPagerAdapter
import com.example.myapplication.main.home.browse.BrowsePizzeriasFragment
import com.example.myapplication.main.home.myslice.MySliceFragment
import com.example.myapplication.main.home.tracking.TrackingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    enum class HomeScreenTab(val position: Int) {
        TRACKING(0),
        MY_SLICE(1),
        BROWSE_PIZZERIAS(2);

        companion object {
            fun valueOf(value: Int): HomeScreenTab? = values().find { it.position == value }
        }
    }

    private val tabsPagerAdapter: TabsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViewPager()
        createEvents()
    }

    private fun initViewPager() {
        val tabsAdapter =
            TabsPagerAdapter(
                supportFragmentManager,
                object : GeneralFragmentPagerAdapter.GeneralPagerAdapterListener {
                    override val pagerFragmentsCount: Int
                        get() = HomeScreenTab.values().size

                    override fun createPagerFragmentInstance(position: Int): Fragment? =
                        when (HomeScreenTab.valueOf(position)) {
                            HomeScreenTab.TRACKING -> TrackingFragment()
                            HomeScreenTab.MY_SLICE -> MySliceFragment()
                            HomeScreenTab.BROWSE_PIZZERIAS -> BrowsePizzeriasFragment()
                            null -> null
                        }
                })

        home_view_pager.offscreenPageLimit = HomeScreenTab.values().size
        home_view_pager.adapter = tabsAdapter

    }

    private fun createEvents() {
        home_bottom_navigation_view.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean = when (menuItem.itemId) {
        R.id.action_tracking -> {
            home_view_pager.setCurrentItem(HomeScreenTab.TRACKING.position, false)
            true
        }
        R.id.action_my_slice -> {
            home_view_pager.setCurrentItem(HomeScreenTab.MY_SLICE.position, false)
            true
        }
        R.id.action_browse_pizzerias -> {
            home_view_pager.setCurrentItem(HomeScreenTab.BROWSE_PIZZERIAS.position, false)
            true
        }
        else -> false
    }

}