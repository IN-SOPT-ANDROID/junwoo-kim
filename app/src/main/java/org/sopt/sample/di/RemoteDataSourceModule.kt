package org.sopt.sample.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.sample.data.util.Constant
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    @AuthRetrofit
    fun provideSoptRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constant.SOPT_BAST_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(Constant.APPLICATION_JSON.toMediaType()))
            .build()

    @Singleton
    @Provides
    @ReqresRetrofit
    fun provideReqresRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constant.REQRES_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(Constant.APPLICATION_JSON.toMediaType()))
            .build()

    @Singleton
    @Provides
    @MusicRetrofit
    fun provideMusicRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constant.SOPT_MUSIC_BAST_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(Constant.APPLICATION_JSON.toMediaType()))
            .build()

    @Qualifier
    annotation class AuthRetrofit

    @Qualifier
    annotation class ReqresRetrofit

    @Qualifier
    annotation class MusicRetrofit

}