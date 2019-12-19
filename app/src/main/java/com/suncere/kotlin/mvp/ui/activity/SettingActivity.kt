package com.suncere.kotlin.mvp.ui.activity

import android.os.Bundle
import android.view.View
import com.suncere.kotlin.base.ext.onClick
import com.suncere.kotlin.base.ui.activity.BaseActivity
import com.suncere.kotlin.mvp.R
import com.suncere.kotlin.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_setting.*
import org.jetbrains.anko.toast

/**
 * @author:     wuchao
 * @date:       2018/7/4 17:19
 * @desciption: 设置界面
 */
class SettingActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        mUserProtocolTv.onClick {
            toast("用户协议")
        }
        mFeedBackTv.onClick {
            toast("反馈意见")
        }
        mAboutTv.onClick {
            toast("关于")
        }

        mLogoutBtn.text = "退出登录"

        mLogoutBtn.onClick(this)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mLogoutBtn -> {
                //退出登录，清空本地用户数据
                toast("退出登录")
                UserPrefsUtils.putUserInfo(null)
                finish()
            }
        }
    }
}