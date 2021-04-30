package com.example.mycollapsingtoolbar

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*

class SampleBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance(): SampleBottomSheetDialogFragment {
            return SampleBottomSheetDialogFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = true
        initToolbar()
        clickListener()
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val mBottomSheetDialog = dialog as? BottomSheetDialog
        mBottomSheetDialog?.setCanceledOnTouchOutside(false)
        mBottomSheetDialog?.setOnShowListener {
            val mBehavior = BottomSheetBehavior.from(
                dialog.findViewById<FrameLayout>(R.id.design_bottom_sheet) as ViewGroup
            )
            mBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        return dialog
    }

    private fun initToolbar() {
        toolbar?.run {
            tv_title_bottom_sheet.text = getString(R.string.bottom_sheet)
            iv_close_bottom_sheet.setOnClickListener {
                dismiss()
            }
        }
    }

    private fun clickListener() {
        btn_close_bottom_sheet.setOnClickListener {
            dismiss()
        }
    }
}