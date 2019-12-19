package com.suncere.kotlin.pay.injection.component

import com.suncere.kotlin.base.injection.PerComponentScope
import com.suncere.kotlin.base.injection.component.ActivityComponent
import com.suncere.kotlin.pay.injection.module.PayModule
import com.suncere.kotlin.pay.ui.activity.CashRegisterActivity
import dagger.Component

/**
 * @author:     wuchao
 * @date:       2018/7/24 17:13
 * @desciption: 支付Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)]
        , modules = [(PayModule::class)])
interface PayComponent {
    fun inject(activity: CashRegisterActivity)
}