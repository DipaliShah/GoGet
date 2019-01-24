package com.goget.utils

import android.content.Context
import android.net.ConnectivityManager


/**
 * Created by Dipali Shah on 24/1/19
 */
class NetworkUtils {

    companion object {

        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnected
        }
    }
}