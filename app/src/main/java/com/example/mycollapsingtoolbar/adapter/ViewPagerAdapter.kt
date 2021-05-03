package com.example.mycollapsingtoolbar.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mycollapsingtoolbar.R
import com.example.mycollapsingtoolbar.fragment.CommonCardFragment
import com.example.mycollapsingtoolbar.fragment.CommonFragment

class ViewPagerAdapter constructor(activity: AppCompatActivity, private var isCard: Boolean) :
    FragmentPagerAdapter(
        activity.supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    private var titleList = activity.resources.getStringArray(R.array.tab_string_list)

    private val completedFragment by lazy {
        CommonFragment.newInstance(R.color.colorPrimaryDark)
    }

    private val pendingFragment by lazy {
        CommonFragment.newInstance(R.color.colorAccent)
    }

    private val cancelledFragment by lazy {
        CommonFragment.newInstance(R.color.colorPrimary)
    }

    private val cardFragment1 by lazy {
        CommonCardFragment.newInstance(R.color.colorPrimaryDark)
    }

    private val cardFragment2 by lazy {
        CommonCardFragment.newInstance(R.color.colorAccent)
    }

    private val cardFragment3 by lazy {
        CommonCardFragment.newInstance(R.color.colorPrimary)
    }

    override fun getCount(): Int = titleList.size

    override fun getItem(position: Int): Fragment {
        return if (isCard) {
            when (position) {
                0 -> cardFragment1
                1 -> cardFragment2
                2 -> cardFragment3
                else -> cardFragment1
            }
        } else {
            when (position) {
                0 -> completedFragment
                1 -> pendingFragment
                2 -> cancelledFragment
                else -> completedFragment
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? = titleList[position]
}