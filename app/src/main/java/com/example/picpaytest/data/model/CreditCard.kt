package com.example.picpaytest.data.model

data class CreditCard(
    val numberCard:String,
    val holderName:String,
    val expirationDate: String,
    val cvvCard: Int)