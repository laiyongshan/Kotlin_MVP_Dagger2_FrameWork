package com.suncere.kotlin.mvp.injection.module

import com.suncere.kotlin.mvp.service.TestService
import com.suncere.kotlin.mvp.service.impl.TestServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author lys
 * @time 2019/12/13 18:05
 * @desc:
 */
@Module
class TestModule {

    @Provides
    fun provideTestService(testService: TestServiceImpl): TestService {
        return testService
    }
}