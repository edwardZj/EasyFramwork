package com.zj.baseui

import android.view.View

const val CLICK_DURING_TIME = 700


/**
 * 处理了短时间内双击的情况
 */
fun <T : View> T.clickListener(block: (T) -> Unit) {
    setOnClickListener(object : NoDoubleClickListener() {
        override fun noDoubleClick(v: View?) {
            block(this@clickListener)
        }
    })
}

/**
 * 处理了短时间内双击的情况
 */
fun <T : View> T.clickListener(listener: View.OnClickListener?) {
    if (listener == null) {
        setOnClickListener(null)
    } else {
        setOnClickListener(object : NoDoubleClickListener() {
            override fun noDoubleClick(v: View?) {
                listener.onClick(this@clickListener)
            }
        })
    }
}

private abstract class NoDoubleClickListener : View.OnClickListener {
    var clickTime = 0L

    override fun onClick(v: View?) {
        val currentTime = System.currentTimeMillis()
        if ((currentTime - clickTime) > CLICK_DURING_TIME) {
            clickTime = currentTime
            noDoubleClick(v)
        }
    }

    abstract fun noDoubleClick(v: View?)

}