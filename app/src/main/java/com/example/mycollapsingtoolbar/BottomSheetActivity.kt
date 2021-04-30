package com.example.mycollapsingtoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bottom_sheet.*

class BottomSheetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)
        clickListener()

    }

    private fun showButtomSheet() {
        val sampleBottomSheetDialogFragment = SampleBottomSheetDialogFragment.newInstance()
        sampleBottomSheetDialogFragment.show(supportFragmentManager, "BottomSheet")
    }

    private fun clickListener() {
        btn_bottom_sheet.setOnClickListener {
            showButtomSheet()
        }
    }
}