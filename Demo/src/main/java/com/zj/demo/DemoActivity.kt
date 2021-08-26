package com.zj.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zj.demo.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tv.setOnClickListener { binding.tv.text = "你好 世界" }

//        ImmersionBar.with(this)
//            .transparentStatusBar()           //透明状态栏和导航栏，不写默认状态栏为透明色，导航栏为黑色（设置此方法，fullScreen()方法自动为true）
//            .navigationBarColor(R.color.transparent) //导航栏颜色，不写默认黑色
//            .navigationBarAlpha(0.0f)  //导航栏透明度，不写默认0.0F
//            .init()

    }


}