package com.suncere.kotlin.mvp.service.impl

import com.suncere.kotlin.base.ext.convert
import com.suncere.kotlin.mvp.api.protocol.TestBean
import com.suncere.kotlin.mvp.api.repository.TestRepository
import com.suncere.kotlin.mvp.service.TestService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author lys
 * @time 2019/12/13 18:03
 * @desc:
 */
class TestServiceImpl @Inject constructor() : TestService {

    @Inject
    lateinit var testRepository: TestRepository

    override fun getStationList(ReportTimeType: Int, PositionType: String): Observable<MutableList<TestBean>?> {
        return testRepository.getStationList(ReportTimeType, PositionType).convert()
    }

}


