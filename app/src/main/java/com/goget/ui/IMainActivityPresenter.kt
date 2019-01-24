package com.goget.ui

import com.goget.base.MvpPresenter


/**
 * Created by Dipali Shah on 24/1/19
 */
interface IMainActivityPresenter<V : IMainView> : MvpPresenter<V> {
    fun getWeatherData()
}