package com.goget.base


/**
 * Created by Dipali Shah on 24/1/19
 */
interface BaseView {
    fun noInternetConnectionAvailable() {}

    fun showProgressDialog(title: String, message: String) {}

    fun hideDialog() {}

    fun showthrow(t: Throwable) {}

    fun isNetworkConnected(): Boolean

    fun showErrorToast() {}
}