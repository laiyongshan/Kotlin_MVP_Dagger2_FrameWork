package com.suncere.kotlin.mvp.service

import com.suncere.kotlin.mvp.api.protocol.TestBean
import io.reactivex.Observable

/**
 * @author lys
 * @time 2019/12/13 18:02
 * @desc:
 */
interface TestService {

    /**
     * 获取站点列表
     * */
    fun getStationList(ReportTimeType: Int, PositionType: String): Observable<MutableList<TestBean>?>

}