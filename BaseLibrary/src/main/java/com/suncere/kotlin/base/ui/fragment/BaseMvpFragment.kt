package com.suncere.kotlin.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suncere.kotlin.base.common.BaseApplication
import com.suncere.kotlin.base.injection.component.ActivityComponent
import com.suncere.kotlin.base.injection.component.DaggerActivityComponent
import com.suncere.kotlin.base.injection.module.ActivityModule
import com.suncere.kotlin.base.injection.module.LifecycleProviderModule
import com.suncere.kotlin.base.presenter.BasePresenter
import com.suncere.kotlin.base.presenter.view.BaseView
import com.suncere.kotlin.base.widgets.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/6/26 14:12
 * @desciption:
 */
open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    lateinit var mActivityComponent: ActivityComponent
    //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

    lateinit var mProgressLoading: ProgressLoading

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        mPresenter = this!!.getInstance(this, 0)!!
        initActivityInjection()
        injectComponent()
        mProgressLoading = ProgressLoading.create(activity!!)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /**
     * Dagger注册
     */
    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent
                .builder()
                .appComponent((activity?.application as BaseApplication).mAppComponent)
                .activityModule(ActivityModule(activity!!))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

    override fun showLoading() {
        mProgressLoading.showLoading()
    }

    override fun hideLoading() {
        mProgressLoading.hideLoading()
    }

    override fun onError(error: String) {
        toast(error)
    }
}