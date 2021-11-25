package com.a7medelnoor.androiddevtest.ui.data.model.response

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("offer")
    val offer: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image_url")
    val image_url: String
)