package com.example.picpaytest.feature.contacts

import android.util.Log
import com.example.picpaytest.data.model.Payment
import com.example.picpaytest.data.remote.ServiceRequest

class ContactsPresenter(
    override var view: ContactsContract.View,
    val serviceRequest: ServiceRequest
) : ContactsContract.Presenter {

   override fun test() {
    Log.i("luffy","gomu gomu no pistol")
    }
    override fun testUser(){
        serviceRequest.getUsers(fun(users){
            users.forEach{
             //   Log.i("users",it.toString())
            }},
            fun (fail){
                Log.i("users",fail)

            })
        }

  override  fun testSendRequest(){
        serviceRequest.setPayment(
            fun(transaction){
            Log.i("transaction",transaction.toString())
        },fun(fail){
            Log.i("transaction",fail)
        }, Payment("1111111111111111",789,79.9,"01/18",1002))
    }
    }
