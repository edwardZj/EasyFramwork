package com.zj.net

import android.content.Context
import rxhttp.RxHttpPlugins

object Net {

    @JvmStatic
    fun initRxHttp(context: Context?) {
        context?.let {
            //设置缓存目录
//            val cacheDir: File = File(context.cacheDir, "RxHttpCache")
            RxHttpPlugins.init(null)      //不初始化或者传入null即代表使用默认OkHttpClient对象
                .setDebug(BuildConfig.DEBUG,true)                //是否开启调试模式，开启后，logcat过滤RxHttp，即可看到整个请求流程日志
//                .setCache(File, long, CacheMode)  //配置缓存目录，最大size及缓存模式
//                .setExcludeCacheKeys(String...)   //设置一些key，不参与cacheKey的组拼
//                .setResultDecoder(Function)       //设置数据解密/解码器，非必须
//                .setConverter(IConverter)         //设置全局的转换器，非必须
//                .setOnParamAssembly(Function);    //设置公共参数/请求头回调
        }
    }

}