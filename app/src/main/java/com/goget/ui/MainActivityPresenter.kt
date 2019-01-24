package com.goget.ui

import android.util.Log
import com.goget.base.BasePresenter
import com.goget.webservice.ApiInterface
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by Dipali Shah on 24/1/19
 */
class MainActivityPresenter<V : IMainView> @Inject constructor(mCompositeDisposable: CompositeDisposable) :
    BasePresenter<V>(
        mCompositeDisposable
    ), IMainActivityPresenter<V> {

    private var mApiService: ApiInterface? = null
    override fun getWeatherData() {
        if (getMvpView().isNetworkConnected()) {
            if (mApiService == null)
                mApiService = provideApiService()
            Log.d("presenter", "injected")
            getMvpView().setWeatherData()
        }
    }
}