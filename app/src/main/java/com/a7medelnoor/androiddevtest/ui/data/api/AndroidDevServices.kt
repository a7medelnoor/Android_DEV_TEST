package com.a7medelnoor.androiddevtest.ui.data.api

import com.a7medelnoor.androiddevtest.ui.data.model.response.BaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface AndroidDevServices {
    @GET("test")
    fun getApiResponse(): Call<List<BaseResponse>>
}