package com.zj.demo

import android.app.Application
import com.rousetime.android_startup.StartupManager
import com.zj.utils.UtilsInit

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化管理器
        StartupManager.Builder()
            .addStartup(UtilsInit())
            .build(this)
            .start()
            .await()



    }
}