package com.zj.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import com.zj.main.databinding.ActivityMainBinding
import com.zj.splash.SplashActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //开启splash界面
        Handler().postDelayed({ startActivity(Intent(this, SplashActivity::class.java)) }, 1000)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //清除背景,防止过度绘制
        window.decorView.background = null
//        window.setBackgroundDrawable(null)
        //状态栏字体深色
        window.decorView.systemUiVisibility =
            window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

//        ImmersionBar.with(this)
//            .transparentStatusBar()           //透明状态栏和导航栏，不写默认状态栏为透明色，导航栏为黑色（设置此方法，fullScreen()方法自动为true）
//            .navigationBarColor(R.color.transparent) //导航栏颜色，不写默认黑色
//            .navigationBarAlpha(0.0f)  //导航栏透明度，不写默认0.0F
//            .init()

//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        navView.setupWithNavController(navController)
    }


}