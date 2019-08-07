package com.example.picpaytest.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceProvider {
    companion object {

        val retrofit = Retrofit
        .Builder()
        .baseUrl("http://careers.picpay.com/tests/mobdev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val request = retrofit.create(ApiService::class.java)
}
}