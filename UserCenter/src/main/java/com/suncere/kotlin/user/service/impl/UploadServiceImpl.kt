package com.suncere.kotlin.user.service.impl

import com.suncere.kotlin.base.ext.convert
import com.suncere.kotlin.user.data.respository.UploadRepository
import com.suncere.kotlin.user.service.UploadService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/2 16:15
 * @desciption: 上传业务实现类
 */
class UploadServiceImpl @Inject constructor() : UploadService {
    @Inject
    lateinit var reponsitory: UploadRepository

    override fun getUploadToken(): Observable<String> {
        return reponsitory.getUploadToken().convert()
    }
}