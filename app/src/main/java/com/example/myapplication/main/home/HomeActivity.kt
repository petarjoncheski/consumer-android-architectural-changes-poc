package com.example.myapplication.main.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    enum class HomeScreenTab(val position: Int) {
        TRACKING(0),
        MY_SLICE(1),
        BROWSE_PIZZERIAS(2);

        companion object {
            fun valueOf(value: Int): HomeScreenTab? = values().find { it.position == value }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
        createEvents()
    }

    private fun init() {
        home_bottom_navigation_view.setupWithNavController(nav_host_fragment.findNavController())
    }


    private fun createEvents() {
        nav_host_fragment.findNavController().addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.action_tracking -> {
                    Toast.makeText(this@HomeActivity, "Navigated to tracking", Toast.LENGTH_SHORT).show()
                }
                R.id.action_my_slice -> {
                    Toast.makeText(this@HomeActivity, "Navigated to my slice", Toast.LENGTH_SHORT).show()
                }
                R.id.action_browse_pizzerias -> {
                    Toast.makeText(this@HomeActivity, "Navigated to browse pizzerias", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}