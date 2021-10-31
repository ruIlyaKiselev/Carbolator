package com.example.carbolator.di

import com.example.carbolator.network.CarbolatorApiContract
import com.example.carbolator.network.CarbolatorService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCarbolatorService(): CarbolatorService {

        val loggingInterceptor by lazy {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

        val headersInterceptor by lazy {
            object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val originalRequest = chain.request()

                    val requestWithHeaders = originalRequest.newBuilder()
                        .addHeader(CarbolatorApiContract.HOST_HEADER_KEY, CarbolatorApiContract.HOST_HEADER_VALUE)
                        .addHeader(CarbolatorApiContract.ACCEPT_HEADER_KEY, CarbolatorApiContract.ACCEPT_HEADER_VALUE)
                        .build()

                    return chain.proceed(requestWithHeaders)
                }
            }
        }

        val httpClient by lazy {
            OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(headersInterceptor)
                .build()
        }

        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(CarbolatorApiContract.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CarbolatorService::class.java)

    }
}