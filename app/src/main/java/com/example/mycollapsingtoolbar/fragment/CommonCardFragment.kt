package com.example.mycollapsingtoolbar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mycollapsingtoolbar.R
import kotlinx.android.synthetic.main.fragment_card_common.*

class CommonCardFragment : Fragment() {

    private var intColor: Int? = null

    companion object {
        fun newInstance(color: Int): CommonCardFragment {
            val mCommonCardFragment = CommonCardFragment()
            val bundle = Bundle()
            bundle.putInt("COLOR", color)
            mCommonCardFragment.arguments = bundle
            return mCommonCardFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromBundle()
    }

    private fun getDataFromBundle() {
        arguments?.let {
            intColor = it.getInt("COLOR")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intColor?.let {
            cv_card.setBackgroundColor(resources.getColor(it))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card_common, container, false)
    }
}