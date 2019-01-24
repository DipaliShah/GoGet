package com.goget.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.goget.di.ActivityContext
import com.goget.ui.IMainActivityPresenter
import com.goget.ui.IMainView
import com.goget.ui.MainActivityPresenter
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Dipali Shah on 24/1/19
 */
@Module
class ActivityModule(val activity: AppCompatActivity) {

    @Provides
    @ActivityContext
    internal fun provideContext(): Context {
        return activity
    }

    @Provides
    internal fun provideActivity(): AppCompatActivity {
        return activity
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }


    @Provides
    internal fun provideGson(): Gson {
        return Gson()
    }

    /*@Provides
    internal fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }*/
    @Provides
    internal fun provideMainActivityMvpPresenter(
        presenter: MainActivityPresenter<IMainView>
    ): IMainActivityPresenter<IMainView> {
        return presenter
    }
}