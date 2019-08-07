package com.example.picpaytest.data.remote

import com.example.picpaytest.data.model.Payment
import com.example.picpaytest.data.model.PaymentCallback
import com.example.picpaytest.data.model.User
import com.example.picpaytest.data.remote.ServiceProvider.Companion.request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceRequest {

    fun getUsers(
        sucess:(ArrayList<User>)->Unit,
        failure:(error:String)->Unit
    ){
        request.searchUser()
            .enqueue(object : Callback<ArrayList<User>> {
                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    failure(t.message.toString())
                }

                override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                    response.body()?.let(sucess)
                }
            })
    }

    fun setPayment(sucess:(transition: PaymentCallback)->Unit,
                   failure:(error:String)->Unit,
                   payment: Payment
    ){
        request.sendPayment(payment)
            .enqueue(object : Callback<PaymentCallback>{
                override fun onFailure(call: Call<PaymentCallback>, t: Throwable) {
                    failure(t.message.toString())
                }

                override fun onResponse(call: Call<PaymentCallback>, response: Response<PaymentCallback>) {
                    response.body()?.let (sucess)
                }
            })
    }
}