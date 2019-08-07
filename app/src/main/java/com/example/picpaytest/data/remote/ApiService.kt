package com.example.picpaytest.data.remote


import com.example.picpaytest.data.model.Payment
import com.example.picpaytest.data.model.PaymentCallback
import com.example.picpaytest.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("users")
    fun searchUser(): Call<ArrayList<User>>

    @POST("transaction")
    fun sendPayment(@Body payment: Payment):Call<PaymentCallback>
}