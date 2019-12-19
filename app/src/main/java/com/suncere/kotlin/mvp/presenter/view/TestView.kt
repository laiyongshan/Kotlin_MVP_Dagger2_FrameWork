package com.suncere.kotlin.mvp.presenter.view

import com.suncere.kotlin.base.presenter.view.BaseView
import com.suncere.kotlin.mvp.api.protocol.TestBean

/**
 * @author lys
 * @time 2019/12/12 17:51
 * @desc:
 */
interface TestView : BaseView {

    /**
     * 获取站点列表成功
     * */
    fun onGetStationListSuccess(result: MutableList<TestBean>?)

}