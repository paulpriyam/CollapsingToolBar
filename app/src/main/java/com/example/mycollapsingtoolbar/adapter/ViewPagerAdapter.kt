package com.example.mycollapsingtoolbar.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mycollapsingtoolbar.CollapsingToolBar4
import com.example.mycollapsingtoolbar.R
import com.example.mycollapsingtoolbar.fragment.CommonFragment

class ViewPagerAdapter constructor(activity: CollapsingToolBar4) : FragmentPagerAdapter(
    activity.supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    private var titleList = activity.resources.getStringArray(R.array.tab_string_list)

    private val completedFragment by lazy {
        CommonFragment.newIntance(R.color.colorPrimaryDark)
    }

    private val pendingFragment by lazy {
        CommonFragment.newIntance(R.color.colorAccent)
    }

    private val cancelledFragment by lazy {
        CommonFragment.newIntance(R.color.colorPrimary)
    }

    override fun getCount(): Int = titleList.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> completedFragment
            1 -> pendingFragment
            2 -> cancelledFragment
            else -> completedFragment
        }

    override fun getPageTitle(position: Int): CharSequence? = titleList[position]
}