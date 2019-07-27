package com.example.picpaytest.data.remote

import com.example.picpaytest.data.model.Payment
import com.example.picpaytest.data.model.PaymentCallback
import com.example.picpaytest.data.model.Transaction
import com.example.picpaytest.data.model.User
import com.example.picpaytest.data.remote.ServiceProvider.Companion.request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceRequest() {

    fun getUsers(
        sucess:(List<User>)->Unit,
        failure:(error:String)->Unit
    ){

        request.searchUser()
            .enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                failure(t.message.toString())
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
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