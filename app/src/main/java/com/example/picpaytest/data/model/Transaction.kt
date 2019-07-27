package com.example.picpaytest.data.model

import com.google.gson.annotations.SerializedName

data class PaymentCallback(
    val transaction: Transaction)

data class Transaction
    (val id:Int,
     val value:Double,
     @SerializedName("destination_user")
     val destinationUser:User,
     val success:Boolean,
     val status:String)
