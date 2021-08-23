package com.zj.splash

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import com.zj.splash.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ImmersionBar.with(this)
//            .transparentBar()             //透明状态栏和导航栏，不写默认状态栏为透明色，导航栏为黑色（设置此方法，fullScreen()方法自动为true）
////            .statusBarColor(R.color.colorPrimary)     //状态栏颜色，不写默认透明色
//            .navigationBarColor(R.color.transparent) //导航栏颜色，不写默认黑色
////            .statusBarAlpha(0.3f)  //状态栏透明度，不写默认0.0f
//            .navigationBarAlpha(0.0f)  //导航栏透明度，不写默认0.0F
////            .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
////            .navigationBarDarkIcon(true) //导航栏图标是深色，不写默认为亮色
////            .autoDarkModeEnable(true) //自动状态栏字体和导航栏图标变色，必须指定状态栏颜色和导航栏颜色才可以自动变色哦
////            .flymeOSStatusBarFontColor(R.color.btn3)  //修改flyme OS状态栏字体颜色
////            .hideBar(BarHide.FLAG_HIDE_BAR)  //隐藏状态栏或导航栏或两者，不写默认不隐藏
////            .fitsSystemWindows(true)    //解决状态栏和布局重叠问题，任选其一，默认为false，当为true时一定要指定statusBarColor()，不然状态栏为透明色，还有一些重载方法
////            .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
////            .keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)  //单独指定软键盘模式
////            .setOnNavigationBarListener(onNavigationBarListener) //导航栏显示隐藏监听，目前只支持华为和小米手机
//            .init()

        binding.root.postDelayed({
            if (!isFinishing){
                finish()
            }
        }, 3000)

    }

    override fun onBackPressed() {
//        super.onBackPressed()
    }

}