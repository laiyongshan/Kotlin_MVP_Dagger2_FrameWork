package com.suncere.kotlin.user.presenter

import com.suncere.kotlin.base.ext.execute
import com.suncere.kotlin.base.presenter.BasePresenter
import com.suncere.kotlin.base.rx.BaseObserver
import com.suncere.kotlin.user.presenter.view.ResetPwdView
import com.suncere.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/6/29 16:56
 * @desciption: 重置密码Presenter
 */
class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {

    @Inject
    lateinit var userService: UserService

    /*
    重置密码
     */
    fun resetPwd(mobile: String, pwd: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.resetPwd(mobile, pwd)
                .execute(object : BaseObserver<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        if (t)
                            mView.onResetPwdResult("重置密码成功")
                    }
                }, lifecycleProvider)
    }
}