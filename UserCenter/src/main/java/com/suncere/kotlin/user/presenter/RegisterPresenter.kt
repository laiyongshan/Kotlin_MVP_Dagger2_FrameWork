package com.suncere.kotlin.user.presenter

import com.suncere.kotlin.base.ext.execute
import com.suncere.kotlin.base.presenter.BasePresenter
import com.suncere.kotlin.base.rx.BaseObserver
import com.suncere.kotlin.user.presenter.view.RegisterView
import com.suncere.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/6/21 15:31
 * @desciption: 用户注册Presenter
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService


    fun register(mobile: String, pwd: String, verifyCode: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.register(mobile, pwd, verifyCode)
                .execute(object : BaseObserver<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        if (t)
                            mView.onRegisterResult("注册成功")
                    }
                }, lifecycleProvider)
    }

}