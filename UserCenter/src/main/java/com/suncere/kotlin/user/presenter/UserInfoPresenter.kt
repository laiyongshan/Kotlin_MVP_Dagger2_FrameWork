package com.suncere.kotlin.user.presenter

import com.suncere.kotlin.base.ext.execute
import com.suncere.kotlin.base.presenter.BasePresenter
import com.suncere.kotlin.base.rx.BaseObserver
import com.suncere.kotlin.user.data.protocol.UserInfo
import com.suncere.kotlin.user.presenter.view.UserInfoView
import com.suncere.kotlin.user.service.UploadService
import com.suncere.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/6/30 22:23
 * @desciption: 编辑用户资料Presenter
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService
    @Inject
    lateinit var uploadService: UploadService

    /*
    获取七牛云上传凭证
     */
    fun getUploadToken() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        uploadService.getUploadToken()
                .execute(object : BaseObserver<String>(mView) {
                    override fun onNext(t: String) {
                        super.onNext(t)
                        mView.onGetUploadTokenResult(t)
                    }
                }, lifecycleProvider)
    }

    /*
     编辑用户资料
     */
    fun editUser(userIcon: String, userName: String, userGender: String, userSign: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.editUser(userIcon, userName, userGender, userSign)
                .execute(object :BaseObserver<UserInfo>(mView){
                    override fun onNext(t: UserInfo) {
                        super.onNext(t)
                        mView.onEditUserResult(t)
                    }
                },lifecycleProvider)
    }
}