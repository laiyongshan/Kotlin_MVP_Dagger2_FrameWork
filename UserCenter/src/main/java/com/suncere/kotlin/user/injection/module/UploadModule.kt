package com.suncere.kotlin.user.injection.module

import com.suncere.kotlin.user.service.UploadService
import com.suncere.kotlin.user.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/7/2 16:13
 * @desciption: 上传Module
 */
@Module
class UploadModule {

    @Provides
    fun providerUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }
}