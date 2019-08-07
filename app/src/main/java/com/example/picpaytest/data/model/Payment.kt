package com.example.picpaytest.data.model

import com.google.gson.annotations.SerializedName

data class Payment (
    @SerializedName("card_number")
    val cardNumber: String,
    val cvv: String,
    val value: String,
    @SerializedName("expiry_date")
    val expiryDate:String,
    @SerializedName("destination_user_id")
    val destinationUserId:Int
)