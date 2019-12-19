package com.suncere.kotlin.user.utils

import com.suncere.kotlin.base.common.BaseConstant
import com.suncere.kotlin.base.utils.AppPrefsUtils
import com.suncere.kotlin.provider.common.ProviderConstant
import com.suncere.kotlin.user.data.protocol.UserInfo

/**
 * @author:     wuchao
 * @date:       2018/7/2 17:27
 * @desciption: 本地存储用户相关信息
 */
object UserPrefsUtils {
    /*
        退出登录时，传入null,清空存储
     */
    fun putUserInfo(userInfo: UserInfo?) {
        AppPrefsUtils.putString(BaseConstant.KEY_SP_TOKEN, userInfo?.id ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_ICON, userInfo?.userIcon ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_NAME, userInfo?.userName ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_MOBILE, userInfo?.userMobile ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_GENDER, userInfo?.userGender ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_SIGN, userInfo?.userSign ?: "")
    }
}