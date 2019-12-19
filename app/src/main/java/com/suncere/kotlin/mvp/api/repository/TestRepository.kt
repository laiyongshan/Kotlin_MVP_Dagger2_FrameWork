package com.suncere.kotlin.mvp.api.repository

import com.suncere.kotlin.base.data.net.RetrofitFactory
import com.suncere.kotlin.base.data.protocol.BaseResp
import com.suncere.kotlin.mvp.api.port.TestApi
import com.suncere.kotlin.mvp.api.protocol.TestBean
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author lys
 * @time 2019/12/13 09:14
 * @desc:数据层
 */
class TestRepository @Inject constructor() {

    /**
     * 获取站点列表
     * */
    fun getStationList(ReportTimeType: Int, StationTypeId: String): Observable<BaseResp<MutableList<TestBean>?>> {
        return RetrofitFactory.instance.create(TestApi::class.java)
                .getStationList(ReportTimeType, StationTypeId)
    }

}