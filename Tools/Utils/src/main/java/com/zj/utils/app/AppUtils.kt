package com.zj.utils.app

import android.content.Context
import android.content.pm.ApplicationInfo

object AppUtils {
    @JvmStatic
    private var isDebug = false

    @JvmStatic
    fun isDebug(): Boolean {
        return isDebug
    }

    @JvmStatic
    fun asyncIsDebug(context: Context) {
        isDebug = context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    }


}