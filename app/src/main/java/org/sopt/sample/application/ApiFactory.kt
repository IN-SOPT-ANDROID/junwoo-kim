package org.sopt.sample.application

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiFactory {
    private val loginRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://3.39.169.52:3000/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val loginService: AuthService by lazy {
        loginRetrofit.create(AuthService::class.java)
    }

    private val requresRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val requeresService: ReqresApi by lazy {
        requresRetrofit.create(ReqresApi::class.java)
    }

//    inline fun <reified T> create(): T = loginRetrofit.create<T>(T::class.java)
//
//    private val _loginService = loginRetrofit.create<AuthService>()


}
