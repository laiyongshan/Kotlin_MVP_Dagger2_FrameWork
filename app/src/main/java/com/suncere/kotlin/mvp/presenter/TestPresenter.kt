package com.suncere.kotlin.mvp.presenter

import android.util.Log
import com.suncere.kotlin.base.ext.execute
import com.suncere.kotlin.base.presenter.BasePresenter
import com.suncere.kotlin.base.rx.BaseObserver
import com.suncere.kotlin.mvp.api.protocol.TestBean
import com.suncere.kotlin.mvp.presenter.view.TestView
import com.suncere.kotlin.mvp.service.TestService
import javax.inject.Inject

/**
 * @author lys
 * @time 2019/12/12 17:50
 * @desc:
 */
class TestPresenter @Inject constructor() : BasePresenter<TestView>() {

    @Inject
    lateinit var testService: TestService


    /**
     * 获取站点列表
     * */
    fun getStationList(ReportTimeType: Int, PositionType: String) {
        if (!checkNetWork()) {
            return
        }


        testService.getStationList(ReportTimeType, PositionType).execute(object : BaseObserver<MutableList<TestBean>?>(mView) {
            override fun onNext(t: MutableList<TestBean>?) {
                super.onNext(t)
                mView.onGetStationListSuccess(t)
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                Log.e("lys", e.message);
            }

            override fun onComplete() {
                super.onComplete()
            }

        }, lifecycleProvider)
    }


}