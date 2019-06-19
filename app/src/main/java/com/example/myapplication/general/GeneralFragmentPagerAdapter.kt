package com.example.myapplication.general

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import android.util.SparseArray
import android.view.ViewGroup

/**
 * Extend from this class if you need view pager adapter for static fragments(previously defined number of fragments such as tabs).
 * With this view pager the fragments can restore their previous state.
 * Methods in [GeneralPagerAdapterListener] must be implemented.
 */
abstract class GeneralFragmentPagerAdapter(
    fm: FragmentManager,
    private val mGeneralPagerAdapter: GeneralPagerAdapterListener
) :
    FragmentPagerAdapter(fm) {
    val fragments = SparseArray<Fragment>()


    override fun getCount(): Int {
        return mGeneralPagerAdapter.pagerFragmentsCount

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        fragments.put(position, fragment)
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        fragments.removeAt(position)
        super.destroyItem(container, position, `object`)
    }

    @Suppress("UNUSED")
    fun getFragment(position: Int): Fragment? {
        return if (fragments.size() == 0 || position < 0 || position >= fragments.size()) {
            null
        } else fragments.get(position)
    }

    override fun getItem(position: Int): Fragment? {
        return mGeneralPagerAdapter.createPagerFragmentInstance(position)
    }

    /**
     * This interface contains methods that needed to be implemented for [GeneralFragmentPagerAdapter] to work properly.
     */
    interface GeneralPagerAdapterListener {

        /**
         * This method provides the total number of fragments that will be used for [GeneralFragmentPagerAdapter].
         *
         * @return the number of fragments.
         */
        val pagerFragmentsCount: Int

        /**
         * Creates new fragment instance for the provided position.
         *
         * @param position the position of the fragment.
         * @return the new instance of the fragment.
         */
        fun createPagerFragmentInstance(position: Int): androidx.fragment.app.Fragment?
    }
}