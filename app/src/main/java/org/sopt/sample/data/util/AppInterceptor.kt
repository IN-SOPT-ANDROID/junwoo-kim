package org.sopt.sample.data.util

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import java.io.IOException

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