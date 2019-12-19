package com.suncere.kotlin.user.presenter.view

import com.suncere.kotlin.base.presenter.view.BaseView

/**
 * @author:     wuchao
 * @date:       2018/6/29 16:48
 * @desciption: 重置密码 视图回调
 */
interface ResetPwdView : BaseView {

    fun onResetPwdResult(result: String)
}