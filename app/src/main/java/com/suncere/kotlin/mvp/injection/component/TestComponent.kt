package com.suncere.kotlin.mvp.injection.component

import com.suncere.kotlin.base.injection.PerComponentScope
import com.suncere.kotlin.base.injection.component.ActivityComponent
import com.suncere.kotlin.mvp.injection.module.TestModule
import com.suncere.kotlin.mvp.ui.fragment.TestFragment
import dagger.Component


/**
 * @author lys
 * @time 2019/12/13 18:04
 * @desc:
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(TestModule::class))
interface TestComponent {
    fun inject(fragment: TestFragment)
}