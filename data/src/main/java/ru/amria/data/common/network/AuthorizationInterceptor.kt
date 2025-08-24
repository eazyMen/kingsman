package ru.amria.data.common.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import ru.amria.domain.repository.SharedPrefs
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    val prefs: SharedPrefs
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()

        request = request.newBuilder()
            .addHeader("Authorization", "Bearer ${prefs.getAccessToken()}").build()

        return chain.proceed(request)
    }
}