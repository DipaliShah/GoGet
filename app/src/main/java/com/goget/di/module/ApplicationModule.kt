package com.goget.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.goget.di.ApplicationContext
import dagger.Module
import dagger.Provides


/**
 * Created by Dipali Shah on 24/1/19
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return application
    }

    @Provides
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    internal fun provideSharedPrefs(): SharedPreferences {
        return application.getSharedPreferences("goget-prefs", Context.MODE_PRIVATE)
    }
}