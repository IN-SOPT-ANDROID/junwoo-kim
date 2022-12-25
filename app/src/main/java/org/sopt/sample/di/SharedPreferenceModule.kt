package org.sopt.sample.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.sopt.sample.data.util.Constant
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext appContext: Context): SharedPreferences {
       return appContext.getSharedPreferences(
            Constant.PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }
}