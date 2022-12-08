package org.sopt.sample.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.sopt.sample.BuildConfig
import org.sopt.sample.di.SharedPreferenceModule
import timber.log.Timber

@HiltAndroidApp
class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        SharedPreferenceModule.init(this)
    }
}