package com.goget.base

import com.goget.webservice.ApiInterface
import com.goget.webservice.RetrofitSingleton
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Dipali Shah on 24/1/19
 */
open class BasePresenter<V : BaseView> @Inject constructor(private val mCompositeDisposable: CompositeDisposable) :
    MvpPresenter<V> {

    private var mBaseView: V? = null

    protected fun <T> subscribe(observable: Observable<T>, onAction: Consumer<in T>, onError: Consumer<Throwable>) {
        mCompositeDisposable.add(
            observable.subscribeOn(Schedulers.io())
                //   .single(observable)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onAction, onError)
        )

    }

    protected fun <T> subscribeSingle(observable: Single<T>, onAction: Consumer<in T>, onError: Consumer<Throwable>) {
        mCompositeDisposable.add(
            observable.subscribeOn(Schedulers.io())
                //   .single(observable)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onAction, onError)
        )

    }

    override fun onAttach(baseView: V) {
        mBaseView = baseView
    }

    override fun onDetach() {
        mCompositeDisposable.dispose()
        mBaseView = null
    }

    fun isViewAttached(): Boolean {
        return mBaseView != null
    }

    fun getMvpView(): V {
        return mBaseView!!
    }

    protected fun provideApiService(): ApiInterface {
        val retrofitSingleton = RetrofitSingleton.getInstance()
        return retrofitSingleton.provideApiService()
    }
}