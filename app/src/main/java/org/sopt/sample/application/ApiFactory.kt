package org.sopt.sample.application

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.sopt.sample.application.Util.Constant.APPLICATION_JOSN
import org.sopt.sample.application.Util.Constant.REQRES_BASE_URL
import org.sopt.sample.application.Util.Constant.SOPT_BAST_URL
import retrofit2.Retrofit

object ApiFactory {
    private val loginRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(SOPT_BAST_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val loginService: AuthService by lazy {
        loginRetrofit.create(AuthService::class.java)
    }

    private val reqresRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(REQRES_BASE_URL)
            .addConverterFactory(Json.asConverterFactory(APPLICATION_JOSN.toMediaType()))
            .build()
    }

    val reqresService: ReqresApi by lazy {
        reqresRetrofit.create(ReqresApi::class.java)
    }

//    inline fun <reified T> create(): T = loginRetrofit.create<T>(T::class.java)
//
//    private val _loginService = loginRetrofit.create<AuthService>()


}
