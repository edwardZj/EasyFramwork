package com.zj.image

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * 中间层代理
 */
object Image {

    @JvmStatic
    fun with(@NonNull context: Context): RequestManager {
        return Glide.with(context)
    }

    fun with(fragment: Fragment): RequestManager {
        return Glide.with(fragment)
    }

    fun with(fragment: android.app.Fragment): RequestManager {
        return Glide.with(fragment)
    }

    fun with(view: View): RequestManager {
        return Glide.with(view)
    }

}

fun ImageView.load(url: String?, placeholder: Int = 0) {
    Glide.with(this).load(url).placeholder(placeholder).into(this)
}

fun ImageView.with(): RequestManager {
    return Glide.with(this)
}

/**
 * 加载图片
 */
fun ImageView.loadImage(context: Context, path: String, placeholder: Int = 0, useCache: Boolean = false) {
    var options = getOptions(placeholder, useCache)
    Glide.with(context).load(path).apply(options).into(this)
}

/**
 * 加载圆形图片
 */
fun ImageView.loadCircleImage(context: Context, path: String, placeholder: Int = 0, useCache: Boolean = false) {
    var options = getOptions(placeholder, useCache)
    options.circleCrop()
    Glide.with(context).load(path).apply(options).into(this)
}

/**
 * 加载圆角图片
 */
fun ImageView.loadRoundCornerImage(context: Context, path: String, roundingRadius: Int = 20, placeholder: Int = 0, useCache: Boolean = false) {
    var options = getOptions(placeholder, useCache)
    Glide.with(context).load(path)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(roundingRadius))).apply(options)
        .into(this)
}

/**
 * 取消加载
 */
fun ImageView.loadClear(context: Context) {
    Glide.with(context).clear(this)
}

private fun ImageView.getOptions(placeholder: Int = 0, useCache: Boolean = false): RequestOptions {
    var options = RequestOptions()
    options.placeholder(placeholder)
    options.priority(Priority.HIGH)
    if (useCache)
        options.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
    return options
}
