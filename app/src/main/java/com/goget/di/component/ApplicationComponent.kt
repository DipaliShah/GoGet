package com.goget.di.component

import android.app.Application
import android.content.Context
import com.goget.GoGet
import com.goget.di.ApplicationContext
import com.goget.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Dipali Shah on 24/1/19
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    abstract fun inject(app: GoGet)

    @ApplicationContext
    abstract fun context(): Context

    abstract fun application(): Application
}