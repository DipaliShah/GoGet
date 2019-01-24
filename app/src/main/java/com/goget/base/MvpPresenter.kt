package com.goget.base


/**
 * Created by Dipali Shah on 24/1/19
 */
interface MvpPresenter<V : BaseView> {

    abstract fun onAttach(baseView: V)

    abstract fun onDetach()

}