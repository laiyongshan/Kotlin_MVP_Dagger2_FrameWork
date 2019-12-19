package com.suncere.kotlin.user.data.respository

import com.suncere.kotlin.base.data.net.RetrofitFactory
import com.suncere.kotlin.base.data.protocol.BaseResp
import com.suncere.kotlin.user.data.api.UploadApi
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/2 16:10
 * @desciption: 上传相关 数据层
 */
class UploadRepository @Inject constructor() {
    /*
     获取七牛云上传凭证
     */
    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UploadApi::class.java)
                .getUploadToken()
    }
}