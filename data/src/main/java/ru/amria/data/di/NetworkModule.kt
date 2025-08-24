package ru.amria.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.amria.data.fashn.FashnApi


val API_KEY = "fa-RjoeGnkB2OJx-Sp1xMI8JxraKF5oOefCUpbFV"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun baseUrl() = "https://api.fashn.ai"

    private fun authInterceptor() = Interceptor { chain ->
        val req = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $API_KEY")
            .addHeader("Content-Type", "application/json")
            .build()
        chain.proceed(req)
    }

    @Provides
    fun okhttpClient(
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(authInterceptor())
            .build()

    @Provides
    fun retrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun authApi(retrofit: Retrofit): FashnApi =
        retrofit.create(FashnApi::class.java)

}