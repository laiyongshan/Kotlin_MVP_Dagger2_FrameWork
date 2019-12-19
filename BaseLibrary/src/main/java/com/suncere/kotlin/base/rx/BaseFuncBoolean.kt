package com.suncere.kotlin.base.rx

import com.suncere.kotlin.base.common.ResultCode
import com.suncere.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * @author:     wuchao
 * @date:       2018/6/26 13:27
 * @desciption: Boolean 类型转换封装
 */
class BaseFuncBoolean<T> : Function<BaseResp<T>, Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        return if (t.Result != ResultCode.SUCCESS) {
            Observable.error(BaseException(t.Result, t.ErrorMessage))
        } else {
            Observable.just(true)
        }
    }
}