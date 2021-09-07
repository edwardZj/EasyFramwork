package com.zj.utils

import com.zj.utils.logger.XLogger

fun String.log(): String {
    XLogger.i(this)
    return this
}

fun Exception.log() {
    XLogger.e(this)
}