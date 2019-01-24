package com.goget

import android.app.Application
import com.goget.di.component.ApplicationComponent
import com.goget.di.component.DaggerApplicationComponent
import com.goget.di.module.ApplicationModule


/**
 * Created by Dipali Shah on 24/1/19
 */
class GoGet : Application() {

    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

        mApplicationComponent!!.inject(this)
    }

    fun getComponent(): ApplicationComponent? {
        return mApplicationComponent
    }

    fun setComponent(applicationComponent: ApplicationComponent) {
        mApplicationComponent = applicationComponent
    }
}