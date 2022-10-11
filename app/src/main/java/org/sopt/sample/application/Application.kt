package org.sopt.sample.application

import android.app.Application
import org.sopt.sample.BuildConfig
import timber.log.Timber

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}