package com.example.mycollapsingtoolbar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mycollapsingtoolbar.R
import kotlinx.android.synthetic.main.fragment_common.*

class CommonFragment : Fragment() {

    private var intColor: Int? = null

    companion object {
        fun newIntance(color: Int): CommonFragment {
            val commonFragment = CommonFragment()
            val bundle = Bundle()
            bundle.putInt("COLOR", color)
            commonFragment.arguments = bundle
            return commonFragment
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_common, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intColor?.let { cl_common_fragment.setBackgroundColor(it) }

    }
}