package com.example.mycollapsingtoolbar


import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_blur_image.*
import kotlinx.android.synthetic.main.layout_scrolling.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        window.setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        window.apply {
//            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//            decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//        }
        setImageResource()
        setAppbarLayoutHeight()
//        setHeight()
        convertToBitmap()
        renderScriptBlur()
//        normal()
        showContentSensitive()
        showSecondaryImage()
    }


    private fun setImageResource() {
        iv_image.setImageResource(R.drawable.woman)
    }

    private fun setAppbarLayoutHeight() {
        val heightDp = (resources.displayMetrics.widthPixels * 0.8).toFloat()
        val lp = abl_app_bar.layoutParams as CoordinatorLayout.LayoutParams
        lp.height = heightDp.toInt()
    }

//    private fun setHeight(){
//        abl_app_bar.post(Runnable {
//            val heightDp = (resources.displayMetrics.widthPixels * 0.8).toFloat()
//            setAppBarOffset(heightDp.toInt())
//        })
//    }
//    private fun setAppBarOffset(offsetPx: Int) {
//        val params = abl_app_bar.layoutParams as CoordinatorLayout.LayoutParams
//        val behavior = params.behavior as AppBarLayout.Behavior?
//        behavior!!.onNestedPreScroll(coordinator_Layout, abl_app_bar, nsv, 0, offsetPx, intArrayOf(0, 0))
//    }

    private fun convertToBitmap(): Bitmap {
        val bitmap = (iv_image.drawable as BitmapDrawable).bitmap
        return bitmap
    }

    private fun normal() {
        val screenWidth = resources.displayMetrics.widthPixels
        val width = iv_image.measuredWidth
        val height = iv_image.measuredHeight
        val screenHeight = resources.displayMetrics.heightPixels
        val destWidth = (screenWidth * 0.90).toInt()
        val destHeight = (screenHeight * 0.8).toInt()
        val putImage = Bitmap.createScaledBitmap(
            convertToBitmap(), destWidth,
            destHeight, false
        )
        iv_image.setImageBitmap(putImage)
    }

    private fun renderScriptBlur() {
        val rs: RenderScript = RenderScript.create(this)
        val input: Allocation = Allocation.createFromBitmap(rs, convertToBitmap())
        val output: Allocation = Allocation.createTyped(rs, input.type)
        val script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs))
        script.setRadius(20f)
        script.setInput(input)
        script.forEach(output)
        output.copyTo(convertToBitmap())
    }

    private fun showContentSensitive() {
        tv_show_image.setOnClickListener {
            iv_image.setImageResource(R.drawable.woman_copy)
        }
    }

    private fun showSecondaryImage() {
        btn_change_image.setOnClickListener {
            iv_image_secondary.setImageResource(R.drawable.woman)
        }
    }
}