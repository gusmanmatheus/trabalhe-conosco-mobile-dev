package com.example.picpaytest.data.model

import java.io.Serializable

data class CreditCard(
    val numberCard:String,
    val holderName:String,
    val expirationDate: String,
    val cvvCard: String):Serializable