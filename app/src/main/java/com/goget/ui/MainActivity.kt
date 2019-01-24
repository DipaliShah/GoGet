package com.goget.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.goget.R
import com.goget.base.AbstractBaseActivity
import com.goget.utils.NetworkUtils
import javax.inject.Inject

class MainActivity : AbstractBaseActivity(), IMainView {

    @Inject
    internal lateinit var mPresenter: IMainActivityPresenter<IMainView>

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(this@MainActivity)
    }

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {
        super.onViewReady(savedInstanceState, intent)
        val component = getActivityComponent()
        if (component != null) {
            component.inject(this)
        }
        mPresenter.onAttach(this)
        mPresenter.getWeatherData()
    }

    override fun setWeatherData() {
        Log.d("dagger","back in activity")
    }
}
