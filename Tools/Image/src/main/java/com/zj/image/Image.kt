package com.zj.image

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

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

fun ImageView.load(url: String?) {
    Glide.with(this).load(url).into(this)
}

fun ImageView.with(): RequestManager {
    return Glide.with(this)
}