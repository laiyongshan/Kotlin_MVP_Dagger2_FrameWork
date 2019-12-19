package com.suncere.kotlin.user.presenter

import com.suncere.kotlin.base.ext.execute
import com.suncere.kotlin.base.presenter.BasePresenter
import com.suncere.kotlin.base.rx.BaseObserver
import com.suncere.kotlin.user.presenter.view.ForgetPwdView
import com.suncere.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/6/29 14:00
 * @desciption: 忘记密码Prresenter
 */
class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var userService: UserService

    fun forgetPwd(mobile: String, verifyCode: String) {
        if (!checkNetWork()) {
            return
        }
        userService.forgetPwd(mobile, verifyCode)
                .execute(object : BaseObserver<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        if (t)
                            mView.onForgetPwdResult("验证成功")
                    }
                }, lifecycleProvider)
    }
}