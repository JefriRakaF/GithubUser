package com.filensablon.api.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserDummy {
    private const val  BASE_URL = "https://api.github.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInstance = retrofit.create(Github::class.java)
}