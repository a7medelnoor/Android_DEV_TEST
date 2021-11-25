package com.a7medelnoor.androiddevtest.ui.data.api

import com.a7medelnoor.androiddevtest.ui.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var androidDevServices: AndroidDevServices
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    fun getAndroidDevServices(): AndroidDevServices {
        // initialized api service if not initialized yet
        if (!::androidDevServices.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)

                .addConverterFactory(GsonConverterFactory.create())
                .build()

            androidDevServices = retrofit.create(AndroidDevServices::class.java)
        }

        return androidDevServices
    }
}