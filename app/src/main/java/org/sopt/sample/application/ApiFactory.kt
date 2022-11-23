package org.sopt.sample.application

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import org.sopt.sample.application.Util.Constant.APPLICATION_JSON
import org.sopt.sample.application.Util.Constant.REQRES_BASE_URL
import org.sopt.sample.application.Util.Constant.SOPT_BAST_URL
import retrofit2.Retrofit
import timber.log.Timber
import java.io.IOException

object ApiFactory {

    private fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient =
        OkHttpClient.Builder().run {
            addInterceptor(interceptor)
            build()
        }

    private val loginRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(SOPT_BAST_URL)
            .client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val loginService: AuthService by lazy {
        loginRetrofit.create(AuthService::class.java)
    }

    private val reqresRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(REQRES_BASE_URL)
            .client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(Json.asConverterFactory(APPLICATION_JSON.toMediaType()))
            .build()
    }

    val reqresService: ReqresApi by lazy {
        reqresRetrofit.create(ReqresApi::class.java)
    }


    class AppInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
            val request = request()
            val response = proceed(request)
            Timber.d(request.toString())
            if(response.code in 200..299)
                Timber.d(response.toString())
            else if(response.code in 400..599)
                Timber.e(response.toString())

            return response
        }
    }
}


