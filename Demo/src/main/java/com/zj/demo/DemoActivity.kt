package com.zj.demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.zj.baseui.clickListener
import com.zj.demo.databinding.ActivityDemoBinding
import com.zj.image.Image
import com.zj.image.load
import com.zj.net.Net
import com.zj.utils.extends.toast
import com.zj.utils.log
import rxhttp.toBitmap
import rxhttp.wrapper.param.RxHttp

class DemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Net.initRxHttp(this)

        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var sw = 0;
        binding.tv.setOnClickListener {
            doit()
            binding.tv.text = "Hello World!"

//            binding.iv1.layoutParams.apply {
//                height=WindowManager.LayoutParams.WRAP_CONTENT
//                binding.iv1.layoutParams=this
//            }
            if (sw % 2 == 0) {
                binding.iv1.load("https://cdn2.jianshu.io/assets/default_avatar/15-a7ac401939dd4df837e3bbf82abaa2a8.jpg")
            } else {
                binding.iv1.setImageResource(R.drawable.bg_refund_price)
            }
            sw++

            Demo1().test1(DemoActivity@this)
        }

//        ImmersionBar.with(this)
//            .transparentStatusBar()           //透明状态栏和导航栏，不写默认状态栏为透明色，导航栏为黑色（设置此方法，fullScreen()方法自动为true）
//            .navigationBarColor(R.color.transparent) //导航栏颜色，不写默认黑色
//            .navigationBarAlpha(0.0f)  //导航栏透明度，不写默认0.0F
//            .init()

//        binding.iv1.load("https://cdn2.jianshu.io/assets/default_avatar/15-a7ac401939dd4df837e3bbf82abaa2a8.jpg")

        Image.with(this)
            .load("https://cdn2.jianshu.io/assets/default_avatar/15-a7ac401939dd4df837e3bbf82abaa2a8.jpg")
            .into(binding.iv3)

        lifecycleScope.launchWhenCreated {
            val img =
                RxHttp.get("https://cdn2.jianshu.io/assets/default_avatar/15-a7ac401939dd4df837e3bbf82abaa2a8.jpg")
                    .toBitmap()
//                .toResponse<Demo1>()
//                .life(this)
                    .await()
            binding.iv2.setImageBitmap(img)
        }
        "keyi".log()
        binding.iv2.clickListener {
            toast("1232131")
            Toast.makeText(this, "hahahahah", Toast.LENGTH_SHORT).show()
        }
    }

    private fun doit() {
        val list = arrayListOf<String>("会员95折", "透明状态栏和导航栏", "不写默认状态栏为透明色", "具体跟踪源码")
        binding.vtv.setTextList(list)//加入显示内容,集合类型
        binding.vtv.setText(13f, 0, 0xffffeccd.toInt())//设置属性,具体跟踪源码
        binding.vtv.setTextStillTime(2500)//设置停留时长间隔
        binding.vtv.setAnimTime(2000)//设置进入和退出的时间间隔
        binding.vtv.startAutoScroll()
        binding.vtv.setOnItemClickListener {
            list.set(2, "00000000")
        }//设置进入和退出的时间间隔
    }


}