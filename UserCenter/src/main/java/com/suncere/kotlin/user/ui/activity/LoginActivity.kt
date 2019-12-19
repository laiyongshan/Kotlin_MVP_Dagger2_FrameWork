package com.suncere.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.suncere.kotlin.base.ext.enable
import com.suncere.kotlin.base.ext.onClick
import com.suncere.kotlin.base.ui.activity.BaseMvpActivity
import com.suncere.kotlin.provider.PushProvider
import com.suncere.kotlin.provider.router.RouterPath
import com.suncere.kotlin.user.R
import com.suncere.kotlin.user.data.protocol.UserInfo
import com.suncere.kotlin.user.injection.component.DaggerUserComponent
import com.suncere.kotlin.user.presenter.LoginPresenter
import com.suncere.kotlin.user.presenter.view.LoginView
import com.suncere.kotlin.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * @author:     wuchao
 * @date:       2018/6/28 16:33
 * @desciption: 登录界面
 */
@Route(path = RouterPath.UserCenter.PATH_LOGIN)
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

//    @Autowired(name = RouterPath.MessageCenter.PATH_MESSAGE_PUSH)
    @JvmField
    var mPushProvider: PushProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    /**
     * 初始化视图
     */
    private fun initView() {
        mLoginBtn.enable(mMobileEt) { isBtnEnable() }
        mLoginBtn.enable(mPwdEt) { isBtnEnable() }

        mLoginBtn.onClick(this)
        mForgetPwdTv.onClick(this)
        mHeaderBar.getRightView().onClick(this)
    }

    /**
     * Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder()
                .activityComponent(mActivityComponent)
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    /**
     *  登录回调
     */
    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
        UserPrefsUtils.putUserInfo(result)
        finish()
    }

    /**
     * 点击事件
     */
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mRightTv ->
                startActivity<RegisterActivity>()
            R.id.mLoginBtn ->
                mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString(),
                        mPushProvider?.getPushId() ?: "")
            R.id.mForgetPwdTv -> {
                startActivity<ForgetPwdActivity>()
            }
        }
    }

    /**
     * 判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}