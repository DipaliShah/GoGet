package com.goget.base


/**
 * Created by Dipali Shah on 24/1/19
 */
interface DialogMvpView : MvpView {

    abstract fun dismissDialog(tag: String)
}