package com.zj.utils.extends

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.rousetime.android_startup.AndroidStartup
import com.rousetime.android_startup.Startup
import com.zj.utils.BuildConfig
import com.zj.utils.app.ActivityManager
import com.zj.utils.logger.XLogger

class UtilsInit : AndroidStartup<String>() {

    override fun callCreateOnMainThread(): Boolean = true

    override fun waitOnMainThread(): Boolean = false

    override fun create(context: Context): String? {
        (context as Application).registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                ActivityManager.getInstance().onActivityCreated(activity,savedInstanceState)
            }

            override fun onActivityStarted(activity: Activity) {
                ActivityManager.getInstance().onActivityStarted(activity)
            }

            override fun onActivityResumed(activity: Activity) {
                ActivityManager.getInstance().onActivityResumed(activity)
            }

            override fun onActivityPaused(activity: Activity) {
                 ActivityManager.getInstance().onActivityPaused(activity)
            }

            override fun onActivityStopped(activity: Activity) {
                 ActivityManager.getInstance().onActivityStopped(activity)
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                 ActivityManager.getInstance().onActivitySaveInstanceState(activity,outState)
            }

            override fun onActivityDestroyed(activity: Activity) {
                 ActivityManager.getInstance().onActivityDestroyed(activity)
          }

        })
        if (BuildConfig.DEBUG){
            XLogger.debug("=-=")
        }

        return this.javaClass.simpleName
    }

    override fun dependencies(): List<Class<out Startup<*>>>? {
        return null
    }

}