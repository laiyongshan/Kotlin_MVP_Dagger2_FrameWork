package com.suncere.kotlin.user.presenter.view

import com.suncere.kotlin.base.presenter.view.BaseView
import com.suncere.kotlin.user.data.protocol.UserInfo

/**
 * @author:     wuchao
 * @date:       2018/6/28 15:33
 * @desciption: 用户登录 视图回调
 */
interface LoginView : BaseView {
    fun onLoginResult(result: UserInfo)
}