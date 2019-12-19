package com.suncere.kotlin.mvp.api.port

import com.suncere.kotlin.base.data.protocol.BaseResp
import com.suncere.kotlin.mvp.api.protocol.TestBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author lys
 * @time 2019/12/12 17:55
 * @desc:接口层
 */
interface TestApi {

    /**
     * 获取站点列表数据
     * */
    @GET("AQIMonitor/GetGridAndStationsPollutant")
    fun getStationList(@Query("ReportTimeType") ReportTimeType: Int, @Query("PositionType") PositionType: String): Observable<BaseResp<MutableList<TestBean>?>>


}