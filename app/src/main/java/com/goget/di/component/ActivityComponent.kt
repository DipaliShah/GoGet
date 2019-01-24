package com.goget.di.component

import com.goget.di.PerActivity
import com.goget.di.module.ActivityModule
import com.goget.ui.MainActivity
import dagger.Component


/**
 * Created by Dipali Shah on 24/1/19
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}