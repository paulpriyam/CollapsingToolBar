package com.example.mycollapsingtoolbar

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.example.mycollapsingtoolbar.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_collapsing_tool_bar_4.*


class CollapsingToolBar4 : AppCompatActivity() {
    private lateinit var mViewPagerAdapter: ViewPagerAdapter

    private val TAG: String = CollapsingToolBar4::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_tool_bar_4)
        mViewPagerAdapter = ViewPagerAdapter(this)
        initToolbar()
        initViewPager()
        setActionToolBarColor()
    }

    private fun initToolbar() {
        tb_toolbar_4?.let { it ->
            setSupportActionBar(it)
            supportActionBar?.let { actionBar ->
                actionBar.title = "ToolBar Title"
                actionBar.setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    private fun setActionToolBarColor() {
        try {
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_tulips)
            Palette.from(bitmap).generate { palette ->
                palette?.let {
                    val vibrantColor: Int =
                        it.getVibrantColor(resources.getColor(R.color.primary_500))
                    val vibrantDarkColor: Int =
                        it.getDarkVibrantColor(resources.getColor(R.color.primary_700))
                    ctb_collap_tool_bar_4.setContentScrimColor(vibrantColor)
                    ctb_collap_tool_bar_4.setStatusBarScrimColor(vibrantDarkColor)
                }

            }
        } catch (e: Exception) {
            // if Bitmap fetch fails, fallback to primary colors
            Log.e(TAG, "onCreate: failed to create bitmap from background", e.fillInStackTrace())
            ctb_collap_tool_bar_4.setContentScrimColor(
                ContextCompat.getColor(this, R.color.primary_500)
            )
            ctb_collap_tool_bar_4.setStatusBarScrimColor(
                ContextCompat.getColor(this, R.color.primary_700)
            )
        }
    }

    private fun initViewPager() {
        vp_viewpager?.run {
            offscreenPageLimit = 2
            adapter = mViewPagerAdapter


        }
        tl_tab_layout.setupWithViewPager(vp_viewpager)
        tl_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                vp_viewpager.currentItem = tl_tab_layout.selectedTabPosition
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}