package com.example.mycollapsingtoolbar.activity

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import androidx.viewpager.widget.ViewPager
import com.example.mycollapsingtoolbar.R
import com.example.mycollapsingtoolbar.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_collapsing_tool_bar_5.*


class CollapsingToolBar5 : AppCompatActivity() {

    private lateinit var mViewPagerAdapter: ViewPagerAdapter
    private lateinit var mCommonViewPager: ViewPagerAdapter

    private val TAG: String = CollapsingToolBar5::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_tool_bar_5)
        mViewPagerAdapter = ViewPagerAdapter(this, true)
        mCommonViewPager = ViewPagerAdapter(this, false)
        initToolbar()
        initViewPager()
        getDrawable()
        setActionToolBarColor()
    }

    private fun initToolbar() {
        tb_toolbar_5?.let { it ->
            setSupportActionBar(it)
            supportActionBar?.let { actionBar ->
                actionBar.setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    private fun initViewPager() {
        vp_viewpager_5?.run {
            offscreenPageLimit = 2
            adapter = mViewPagerAdapter
        }
        vp_viewpager_5?.currentItem = 0

        vp_viewpager_55?.run {
            offscreenPageLimit = 2
            adapter = mCommonViewPager
        }
        vp_viewpager_55?.currentItem = 0

        tl_tab_layout_5.setupWithViewPager(vp_viewpager_55)
    }

    private fun getDrawable() {
        vp_viewpager_5.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> vp_viewpager_55.currentItem = 0
                    1 -> vp_viewpager_55.currentItem = 1
                    2 -> vp_viewpager_55.currentItem = 2
                    else -> vp_viewpager_55.currentItem = 0
                }

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
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
                    ctb_collap_tool_bar_5.setContentScrimColor(vibrantColor)
                    ctb_collap_tool_bar_5.setStatusBarScrimColor(vibrantDarkColor)
                }

            }
        } catch (e: Exception) {
            // if Bitmap fetch fails, fallback to primary colors
            Log.e(TAG, "onCreate: failed to create bitmap from background", e.fillInStackTrace())
            ctb_collap_tool_bar_5.setContentScrimColor(
                ContextCompat.getColor(this, R.color.primary_500)
            )
            ctb_collap_tool_bar_5.setStatusBarScrimColor(
                ContextCompat.getColor(this, R.color.primary_700)
            )
        }
    }
}