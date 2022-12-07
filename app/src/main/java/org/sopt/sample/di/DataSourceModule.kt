package org.sopt.sample.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.sopt.sample.data.Util.AppInterceptor
import org.sopt.sample.data.datasource.AuthService
import org.sopt.sample.data.datasource.ReqresApi
import org.sopt.sample.data.Util.Constant
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    private fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient =
        OkHttpClient.Builder().run {
            addInterceptor(interceptor)
            build()
        }

    private val soptRetrofit =
        Retrofit.Builder()
            .baseUrl(Constant.SOPT_BAST_URL)
            .client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(Json.asConverterFactory(Constant.APPLICATION_JSON.toMediaType()))
            .build()


    private val reqresRetrofit =
        Retrofit.Builder()
            .baseUrl(Constant.REQRES_BASE_URL)
            .client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(Json.asConverterFactory(Constant.APPLICATION_JSON.toMediaType()))
            .build()

    @Singleton
    @Provides
    fun provideLoginService(): AuthService {
        return soptRetrofit.create(AuthService::class.java)
    }


    @Singleton
    @Provides
    fun provideReqresService(): ReqresApi {
        return reqresRetrofit.create(ReqresApi::class.java)
    }


}