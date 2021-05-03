package com.example.mycollapsingtoolbar.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycollapsingtoolbar.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_collapsing_tool_bar2.*

class CollapsingToolBar2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_tool_bar2)

//        appBarSetting()
    }

    private fun appBarSetting() {
        abl_app_bar_new.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            layout_image_blur.translationY = -verticalOffset.toFloat()

            val percent =
                    ((Math.abs(verticalOffset)).toFloat()) / 100

            layout_image_blur.alpha = 1F - percent


            layout_image_blur.scaleY = (1F - percent) + percent / 1.199F
            layout_image_blur.scaleX = (1F - percent) + percent / 1.199F
        })
    }
}