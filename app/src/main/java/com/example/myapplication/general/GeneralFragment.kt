package com.example.myapplication.general

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.MainApplication

abstract class GeneralFragment<V : GeneralViewModel> : Fragment() {
    protected var viewModel: V? = null
    //    private val mApplicationComponent: ApplicationComponent
    private var mApplication: MainApplication? = null

    //Set this value to fixate the orientation of the dialog only while visible
    internal open fun getOrientationWhileVisible(): Int = -1

    //    abstract fun injectAtGraph();

    abstract fun bindLayout(inflater: LayoutInflater, container: ViewGroup?): View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return bindLayout(inflater, container)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mApplication = activity?.application as MainApplication
    }
}