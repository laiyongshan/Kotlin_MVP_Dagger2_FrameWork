package com.suncere.kotlin.user.injection.module

import com.suncere.kotlin.user.service.UserService
import com.suncere.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/6/22 17:12
 * @desciption: 用户模块Module
 */
@Module
class UserModule {

    @Provides
    fun provideUserService(service: UserServiceImpl): UserService {
        return service
    }
}