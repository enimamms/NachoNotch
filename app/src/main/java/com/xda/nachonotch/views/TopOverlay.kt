package com.xda.nachonotch.views

import android.content.Context
import android.graphics.Color
import android.view.*
import android.view.WindowManager.LayoutParams.*
import com.xda.nachonotch.util.prefManager

class TopOverlay(context: Context) : BaseOverlay(context, backgroundColor = Color.BLACK) {
    override val params: WindowManager.LayoutParams
        get() = super.params.apply {
            flags = flags or FLAG_DIM_BEHIND
            dimAmount = 0.000001f
            gravity = Gravity.TOP
            width = MATCH_PARENT
            height = context.prefManager.statusBarHeight
        }

    override fun canAdd(): Boolean {
        return context.prefManager.isEnabled
    }

    override fun canShow(): Boolean {
        return !environmentStatus.contains(EnvironmentStatus.STATUS_IMMERSIVE)
                && !environmentStatus.contains(EnvironmentStatus.LANDSCAPE)
    }
}