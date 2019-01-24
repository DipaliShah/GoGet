package com.goget.base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.goget.GoGet
import com.goget.di.component.ActivityComponent
import com.goget.di.component.DaggerActivityComponent
import com.goget.di.module.ActivityModule


/**
 * Created by Dipali Shah on 24/1/19
 */
abstract class AbstractBaseActivity : AppCompatActivity(), BaseView {

    private var mActivityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        mActivityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as GoGet).getComponent())
            .build()

        onViewReady(savedInstanceState, intent)
    }

    @CallSuper
    protected open fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {
        resolveDaggerDependency()
        //To be used by child activities
    }

    protected override fun onDestroy() {
        hideDialog()
        super.onDestroy()

    }

    fun getActivityComponent(): ActivityComponent? {
        return mActivityComponent
    }

    protected fun resolveDaggerDependency() {

    }

    protected abstract fun getContentView(): Int
}