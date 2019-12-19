package com.suncere.kotlin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suncere.kotlin.base.ext.onClick
import com.suncere.kotlin.base.ui.fragment.BaseMvpFragment
import com.suncere.kotlin.mvp.R
import com.suncere.kotlin.mvp.api.protocol.TestBean
import com.suncere.kotlin.mvp.injection.component.DaggerTestComponent
import com.suncere.kotlin.mvp.injection.module.TestModule
import com.suncere.kotlin.mvp.presenter.TestPresenter
import com.suncere.kotlin.mvp.presenter.view.TestView
import kotlinx.android.synthetic.main.fragment_test.*

/**
 * @author lys
 * @time 2019/12/12 17:23
 * @desc:
 */
class TestFragment : BaseMvpFragment<TestPresenter>(), TestView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_test, null)
    }


    override fun injectComponent() {
        DaggerTestComponent.builder()
                .activityComponent(mActivityComponent)
                .testModule(TestModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    /**
     * 初始化控件
     * */
    private fun initView() {
        get_btn.onClick {
            getStationListDatas()
        }
    }


    fun getStationListDatas() {
        mPresenter.getStationList(3, "0")
    }


    override fun onGetStationListSuccess(result: MutableList<TestBean>?) {
        if (result != null) {
            for (testBean: TestBean in result) {
                data_tv.append(testBean.StationName.toString() + "\n")
            }
        }
    }


}