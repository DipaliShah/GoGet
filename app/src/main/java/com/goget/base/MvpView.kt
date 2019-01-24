package com.goget.base

import androidx.annotation.StringRes


/**
 * Created by Dipali Shah on 24/1/19
 */
interface MvpView {
    abstract fun showLoading()

    abstract fun hideLoading()

    abstract fun openActivityOnTokenExpire()

    abstract fun onError(@StringRes resId: Int)

    abstract fun onError(message: String)

    abstract fun showMessage(message: String)

    abstract fun showMessage(@StringRes resId: Int)

    abstract fun isNetworkConnected(): Boolean

    abstract fun hideKeyboard()
}