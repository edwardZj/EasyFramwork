package com.zj.baseui

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.zj.baseui.utils.CommonUIImpl
import com.zj.baseui.utils.NoDoubleClickListener

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

/**
 * view调用用来获取自己所属于的activity或者fragment
 * 只会返回FragmentActivity或者Support包的Fragment
 */
fun View.getOwner(): LifecycleOwner? {
    val activity = context.findActivity()
    if (activity is FragmentActivity) {
        val fragment = CommonUIImpl.findSupportFragment(this, activity)
        return fragment?: activity
    }
    return null
}

fun Context?.findActivity(): Activity? {
    if (this == null) {
        return null
    } else {
        return if (this is Activity) {
            this
        } else if (this is ContextWrapper) {
            findActivity()
        } else {
            null
        }
    }
}