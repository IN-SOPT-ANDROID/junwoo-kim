package org.sopt.sample.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.sopt.sample.application.AppInterceptor
import org.sopt.sample.application.AuthService
import org.sopt.sample.application.ReqresApi
import org.sopt.sample.application.Util.Constant
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    private fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient =
        OkHttpClient.Builder().run {
            addInterceptor(interceptor)
            build()
        }

    @Singleton
    @Provides
    fun provideLoginRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.SOPT_BAST_URL)
            .client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(Json.asConverterFactory(Constant.APPLICATION_JSON.toMediaType()))
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideReqresRetrofit(): Retrofit {
       return Retrofit.Builder()
            .baseUrl(Constant.REQRES_BASE_URL)
            .client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(Json.asConverterFactory(Constant.APPLICATION_JSON.toMediaType()))
            .build()
    }

    @Singleton
    @Provides
    fun provideReqresService(retrofit: Retrofit): ReqresApi {
        return retrofit.create(ReqresApi::class.java)
    }


}