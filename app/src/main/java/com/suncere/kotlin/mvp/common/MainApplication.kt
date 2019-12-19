package com.suncere.kotlin.mvp.common

import android.support.multidex.MultiDex
import com.suncere.kotlin.base.common.BaseApplication

/**
 * @author:     wuchao
 * @date:       2018/7/25 16:55
 * @desciption: 主工程 Application
 */
class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
//        极光推送初始化
//        JPushInterface.setDebugMode(true)
//        JPushInterface.init(this)

        // 主要是添加下面这句代码
        MultiDex.install(this);
    }
}